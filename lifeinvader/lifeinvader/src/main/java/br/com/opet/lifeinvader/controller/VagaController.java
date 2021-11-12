package br.com.opet.lifeinvader.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.opet.lifeinvader.dto.RespVaga;
import br.com.opet.lifeinvader.model.Usuario;
import br.com.opet.lifeinvader.model.Vaga;
import br.com.opet.lifeinvader.repository.UserRepository;
import br.com.opet.lifeinvader.repository.VagaRepository;

@Controller
@RequestMapping("vaga")
public class VagaController {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RespVaga requisicao) {
		return "vaga/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RespVaga requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "vaga/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario user = userRepository.findByUsername(username);
		
		Vaga vagas = requisicao.toVaga();
		vagas.setUsuario(user);
		vagaRepository.save(vagas);
		return "redirect:/home";
	}
}
