package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "profissional_id")
    private Profissionais profissional;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name ="paciente_id")
    private Pacientes paciente;

private LocalDateTime data_consulta;
    @Enumerated(EnumType.STRING)
    private ConsultaStatus status;
    private BigInteger quantidade_horas;
    private BigDecimal valor_consulta;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profissionais getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissionais profissional) {
        this.profissional = profissional;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(LocalDateTime data_consulta) {
        this.data_consulta = data_consulta;
    }

    public ConsultaStatus getStatus() {
        return status;
    }

    public void setStatus(ConsultaStatus status) {
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
