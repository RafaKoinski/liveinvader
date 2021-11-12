package br.com.opet.lifeinvader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.opet.lifeinvader.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {

	@Query("select curso from Usuario where username = :username")
	Usuario findByCurso(@Param("username") String username);

	Usuario findByUsername(String username);

}
