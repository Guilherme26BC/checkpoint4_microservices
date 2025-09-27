package br.com.fiap.checkpoint1.dto.profissional;

import br.com.fiap.checkpoint1.dto.consultas.ConsultasResponse;
import br.com.fiap.checkpoint1.model.Profissionais;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProfissionalResponseCreate {
    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updated_at;

    public ProfissionalResponseCreate toDto(Profissionais profissionais){
        this.setId(profissionais.getId());
        this.setNome(profissionais.getNome());
        this.setEspecialidade(profissionais.getEspecialidade());
        this.setValor_hora(profissionais.getValor_hora());
        this.setCreated_at(profissionais.getCreated_at());
        this.setUpdated_at(profissionais.getUpdated_at());
        return this;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public BigDecimal getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(BigDecimal valor_hora) {
        this.valor_hora = valor_hora;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
