package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.profissional.ProfissionalRequestCreate;
import br.com.fiap.checkpoint1.dto.profissional.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint1.dto.profissional.ProfissionalResponse;
import br.com.fiap.checkpoint1.dto.profissional.ProfissionalResponseCreate;
import br.com.fiap.checkpoint1.model.ConsultaStatus;
import br.com.fiap.checkpoint1.service.ProfissionalService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profissionais")
public class ControllerProfissional {
    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponseCreate> criarProfissional(@RequestBody ProfissionalRequestCreate dto){
        return ResponseEntity.status(201).body(new ProfissionalResponseCreate()
                .toDto(profissionalService.criarProfissional(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> buscarProfissionalPorId(@PathVariable Long id){
        return profissionalService.buscarPorId(id)
                .map(p-> new ProfissionalResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> buscarTodosProfissionais(){
        return ResponseEntity.ok(profissionalService.buscarTodos()
                .stream().map(p-> new ProfissionalResponse().toDto(p))
                .collect(Collectors.toList()));
    }
//

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> atualizarProfissional(@PathVariable Long id, @RequestBody ProfissionalRequestUpdate dto){
        return profissionalService.atualizarProfissional(id, dto)
                .map(p-> new ProfissionalResponse().toDto(p))
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Long id){
       if(profissionalService.deletarPaciente(id)){
           return ResponseEntity.ok().build();
       }else{
           return ResponseEntity.notFound().build();
       }
    }
}
