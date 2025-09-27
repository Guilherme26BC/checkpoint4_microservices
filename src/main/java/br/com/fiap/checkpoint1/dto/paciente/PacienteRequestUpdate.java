package br.com.fiap.checkpoint1.dto.paciente;

import br.com.fiap.checkpoint1.model.Pacientes;

import java.time.LocalDateTime;

public class PacienteRequestUpdate {
   private String nome;
   private String endereco;
   private String bairro;
   private String email;
   private String telefone_completo;

   public Pacientes toModel(Pacientes pacientes){
       pacientes.setNome(this.getNome());
       pacientes.setEndereco(this.getEndereco());
       pacientes.setBairro(this.getBairro());
       pacientes.setEmail(this.getEmail());
       pacientes.setTelefone_completo(this.getTelefone_completo());
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
}
