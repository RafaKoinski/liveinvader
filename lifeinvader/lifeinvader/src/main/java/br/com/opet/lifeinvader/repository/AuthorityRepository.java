package br.com.opet.lifeinvader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opet.lifeinvader.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
