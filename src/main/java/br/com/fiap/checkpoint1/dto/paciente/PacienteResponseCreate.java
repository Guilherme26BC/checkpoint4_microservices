package br.com.fiap.checkpoint1.dto.paciente;

import br.com.fiap.checkpoint1.dto.consultas.ConsultasResponse;
import br.com.fiap.checkpoint1.model.Pacientes;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteResponseCreate {
    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updated_at;

    public PacienteResponseCreate toDto(Pacientes pacientes){
        this.setId(pacientes.getId());
        this.setNome(pacientes.getNome());
        this.setEndereco(pacientes.getEndereco());
        this.setBairro(pacientes.getBairro());
        this.setEmail(pacientes.getEmail());
        this.setTelefone_completo(pacientes.getTelefone_completo());
        this.setData_nascimento(pacientes.getData_nascimento());
        this.setCreated_at(pacientes.getCreated_at());
        this.setUpdated_at(pacientes.getUpdated_at());
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone_completo() {
        return telefone_completo;
    }

    public void setTelefone_completo(String telefone_completo) {
        this.telefone_completo = telefone_completo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
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
