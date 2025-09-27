package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.ConsultaStatus;
import br.com.fiap.checkpoint1.model.Profissionais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissionais, Long>{


}
