package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.consultas.ConsultaRequestUpdate;
import br.com.fiap.checkpoint1.dto.consultas.ConsultasRequestCreate;
import br.com.fiap.checkpoint1.dto.consultas.ConsultasResponse;
import br.com.fiap.checkpoint1.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint1.model.ConsultaStatus;
import br.com.fiap.checkpoint1.model.Consultas;
import br.com.fiap.checkpoint1.model.Pacientes;
import br.com.fiap.checkpoint1.model.Profissionais;
import br.com.fiap.checkpoint1.repository.ConsultaRepository;
import br.com.fiap.checkpoint1.repository.PacienteRepository;
import br.com.fiap.checkpoint1.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public Consultas criarConsulta(ConsultasRequestCreate dto){
        return consultaRepository.save(dto.toModel(profissionalRepository, pacienteRepository));
    }
    public Optional<Consultas> buscarPorId(Long id){
        return consultaRepository.findById(id);
    }
    public List<Consultas> buscarTodos(){
        return consultaRepository.findAll();
    }

    public List<Consultas> buscarConsultaPorStatus(ConsultaStatus consultaStatus){
        return consultaRepository.findByStatus(consultaStatus);
    }
    public Optional<Consultas> atualizarConsulta(){
        return null;
    }
    public boolean deletarConsulta(){
        return false;
    }

    public Optional<Consultas> atualizarConsulta(Long id, ConsultaRequestUpdate dto, ConsultaStatus consultaStatus){
        return consultaRepository.findById(id)
                .map(o-> consultaRepository.save((dto.toModel(o, profissionalRepository, pacienteRepository,consultaStatus))));
    }
    public boolean deletarConsulta(Long id){
        if(consultaRepository.existsById(id)){
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Consultas> buscarPorIdPacienteeConsultaStatus(Long id, ConsultaStatus consultaStatus){
        Pacientes pacientes = pacienteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Paciente inexistente: " + id));
        return consultaRepository.findByPacienteAndStatus(pacientes,consultaStatus);
    }
    public List<Consultas> buscarPorProfissionalEStatus(Long id, ConsultaStatus consultaStatus){
        Profissionais profissionais = profissionalRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profissional inexistente: " + id));

        return consultaRepository.findByProfissionalAndStatus(profissionais, consultaStatus);
    }
}
