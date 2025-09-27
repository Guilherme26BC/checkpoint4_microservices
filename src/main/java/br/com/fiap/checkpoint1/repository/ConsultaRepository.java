package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.ConsultaStatus;
import br.com.fiap.checkpoint1.model.Consultas;
import br.com.fiap.checkpoint1.model.Pacientes;
import br.com.fiap.checkpoint1.model.Profissionais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consultas, Long> {
    public List<Consultas> findByStatus(ConsultaStatus consultaStatus);
    public List<Consultas> findByProfissionalAndStatus(Profissionais profissionais, ConsultaStatus consultaStatus);
    public List<Consultas> findByPacienteAndStatus(Pacientes pacientes, ConsultaStatus consultaStatus);
}
