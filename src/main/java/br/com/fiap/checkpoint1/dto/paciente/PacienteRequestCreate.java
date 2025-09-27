package br.com.fiap.checkpoint1.dto.paciente;

import br.com.fiap.checkpoint1.model.Pacientes;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PacienteRequestCreate {
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data_nascimento;

    public Pacientes toModel(){
        Pacientes pacientes = new Pacientes();
        pacientes.setNome(this.getNome());
        pacientes.setEndereco(this.getEndereco());
        pacientes.setBairro(this.getBairro());
        pacientes.setEmail(this.getBairro());
        pacientes.setTelefone_completo(this.getTelefone_completo());
        pacientes.setData_nascimento(this.getData_nascimento());
        pacientes.setCreated_at(LocalDateTime.now());
        pacientes.setUpdated_at(LocalDateTime.now());
        return pacientes;
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
}
