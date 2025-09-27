package br.com.fiap.checkpoint1.dto.consultas;

import br.com.fiap.checkpoint1.model.Consultas;
import br.com.fiap.checkpoint1.model.Pacientes;
import br.com.fiap.checkpoint1.model.Profissionais;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class ConsultasResponse {
   private Long id;
    private String profissional_nome;
    private String paciente_nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime data_consulta;
    private String status; //mudar para enum dps
    private BigInteger quantidade_horas;
    private BigDecimal valor_consulta;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ConsultasResponse toDto(Consultas consulta){
        this.setId(consulta.getId());
        this.setProfissional_nome(consulta.getProfissional().getNome());
        this.setPaciente_nome(consulta.getPaciente().getNome());
        this.setData_consulta(consulta.getData_consulta());
        this.setStatus(consulta.getStatus().getMensagem());
        this.setQuantidade_horas(consulta.getQuantidade_horas());
        this.setValor_consulta(consulta.getValor_consulta());
        this.setCreated_at(consulta.getCreated_at());
        this.setUpdated_at(consulta.getUpdated_at());
        return this;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfissional_nome() {
        return profissional_nome;
    }

    public void setProfissional_nome(String profissional_nome) {
        this.profissional_nome = profissional_nome;
    }

    public String getPaciente_nome() {
        return paciente_nome;
    }

    public void setPaciente_nome(String paciente_nome) {
        this.paciente_nome = paciente_nome;
    }

    public LocalDateTime getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(LocalDateTime data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getQuantidade_horas() {
        return quantidade_horas;
    }

    public void setQuantidade_horas(BigInteger quantidade_horas) {
        this.quantidade_horas = quantidade_horas;
    }

    public BigDecimal getValor_consulta() {
        return valor_consulta;
    }

    public void setValor_consulta(BigDecimal valor_consulta) {
        this.valor_consulta = valor_consulta;
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
