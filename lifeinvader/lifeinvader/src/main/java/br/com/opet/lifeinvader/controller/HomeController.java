package br.com.opet.lifeinvader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.opet.lifeinvader.dto.RespFiltro;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping
	public String home(RespFiltro requisicao) {
		return "home";
	}

}
