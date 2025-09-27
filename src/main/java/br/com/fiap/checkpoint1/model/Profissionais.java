package br.com.fiap.checkpoint1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Profissionais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "profissional",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Consultas> consultas; //modificar os services, controlers e dtos adicionando a lista

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

    public List<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }
}
