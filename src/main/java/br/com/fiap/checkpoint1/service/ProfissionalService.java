package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.profissional.ProfissionalRequestCreate;
import br.com.fiap.checkpoint1.dto.profissional.ProfissionalRequestUpdate;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    //falta update e delete
    public Profissionais criarProfissional(ProfissionalRequestCreate dto){
        return profissionalRepository.save(dto.toModel());
    }

    public Optional<Profissionais> buscarPorId(Long id){
        return profissionalRepository.findById(id);
    }

    public List<Profissionais> buscarTodos(){
        return profissionalRepository.findAll();
    }

//    public List<Profissionais> buscarPorProfissionalEStatus(Long id, ConsultaStatus consultaStatus){
//        return profissionalRepository.findByIdAndConsultaStatus(id, consultaStatus);
//    }

    public Optional<Profissionais> atualizarProfissional(Long id, ProfissionalRequestUpdate dto){
        return profissionalRepository.findById(id)
                .map(p-> profissionalRepository.save(dto.toModel(p)));
    }
    public boolean deletarPaciente(Long id){
        if(profissionalRepository.existsById(id)){
            profissionalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
