package br.com.opet.lifeinvader.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opet.lifeinvader.model.Usuario;
import br.com.opet.lifeinvader.model.Vaga;
import br.com.opet.lifeinvader.repository.UserRepository;
import br.com.opet.lifeinvader.repository.VagaRepository;

@RestController
@RequestMapping("/api")
public class VagaRest {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private UserRepository userRepository; 
	
	
	
	@GetMapping("vaga")
	public List<Vaga> getVagas() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario user = userRepository.findByUsername(username);
		return vagaRepository.findAllByCurso(user.getCurso());
	}

}
