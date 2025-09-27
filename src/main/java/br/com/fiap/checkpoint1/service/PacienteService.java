package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint1.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint1.model.ConsultaStatus;
import br.com.fiap.checkpoint1.model.Pacientes;
import br.com.fiap.checkpoint1.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    //falta update e delete
    public Pacientes criarPaciente(PacienteRequestCreate dto){
        return pacienteRepository.save(dto.toModel());
    }

    public Optional<Pacientes> buscarPorId(Long id){
        //retorna o primeiro elemento que corresponde
        return pacienteRepository.findById(id);
    }
    public List<Pacientes> buscarTodosPacientes(){
        return pacienteRepository.findAll();
    }


    public Optional<Pacientes> atualizarPaciente(Long id, PacienteRequestUpdate dto){
        return pacienteRepository.findById(id)
                .map(o-> pacienteRepository.save((dto.toModel(o))));
    }

    public boolean deletarPaciente(Long id){
        if(pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
