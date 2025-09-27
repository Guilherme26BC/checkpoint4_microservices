package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.consultas.ConsultaRequestUpdate;
import br.com.fiap.checkpoint1.dto.consultas.ConsultasRequestCreate;
import br.com.fiap.checkpoint1.dto.consultas.ConsultasResponse;
import br.com.fiap.checkpoint1.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint1.dto.paciente.PacienteResponse;
import br.com.fiap.checkpoint1.model.ConsultaStatus;
import br.com.fiap.checkpoint1.service.ConsultaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("consulta")
public class ControllerConsuta {

@Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultasResponse> criarConsulta(@RequestBody ConsultasRequestCreate dto){
    return ResponseEntity.ok().body(new ConsultasResponse().toDto(consultaService.criarConsulta(dto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultasResponse> buscarPorId(@PathVariable Long id){
    return consultaService.buscarPorId(id).map(new ConsultasResponse()::toDto)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ConsultasResponse>> buscarTodas(){
    return ResponseEntity.ok().body(consultaService.buscarTodos().stream().map(
            c -> new ConsultasResponse().toDto(c)
    ).collect(Collectors.toList()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id){
        if(consultaService.deletarConsulta(id)){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ConsultasResponse> atualizarPaciente(@PathVariable Long id, @RequestBody ConsultaRequestUpdate dto, @RequestBody ConsultaStatus consultaStatus){
        return consultaService.atualizarConsulta(id, dto, consultaStatus)
                .map(p->new ConsultasResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/query")
    public ResponseEntity<List<ConsultasResponse>> buscarPorStatus(ConsultaStatus consultaStatus){
        return ResponseEntity.ok().body(consultaService.buscarConsultaPorStatus(consultaStatus)
                .stream().map(p->new ConsultasResponse().toDto(p)).collect(Collectors.toList()));
    }

    @GetMapping("/paciente/{id}/")
    public ResponseEntity<List<ConsultasResponse>> buscarPorIdEStatusConsulta(@PathVariable Long id,  ConsultaStatus consultaStatus){
        return ResponseEntity.ok(consultaService.buscarPorIdPacienteeConsultaStatus(id, consultaStatus)
                .stream().map(p -> new ConsultasResponse().toDto(p)).collect(Collectors.toList()));
    }
    @GetMapping("/profissional/{id}/")
    public ResponseEntity<List<ConsultasResponse>>
    buscarPorIdEStatusConsuta(@PathVariable Long id,  ConsultaStatus consultaStatus){
        return ResponseEntity.ok().body(consultaService.buscarPorProfissionalEStatus(id, consultaStatus)
                .stream().map(new ConsultasResponse()::toDto).collect(Collectors.toList()));
    }
}
