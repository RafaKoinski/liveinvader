package br.com.opet.lifeinvader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.opet.lifeinvader.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
	
	@Query("select v from Vaga v where v.curso = :curso")
	List<Vaga> findAllByCurso(@Param("curso") String curso);

}
