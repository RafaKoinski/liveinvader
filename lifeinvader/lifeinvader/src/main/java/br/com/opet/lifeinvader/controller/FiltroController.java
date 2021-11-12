package br.com.opet.lifeinvader.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.opet.lifeinvader.dto.RespFiltro;
import br.com.opet.lifeinvader.model.Vaga;
import br.com.opet.lifeinvader.repository.VagaRepository;

@Controller
@RequestMapping("vaga/filtro")
public class FiltroController {
	
	@Autowired
	private VagaRepository vagaRepository;

	@PostMapping
	public String filtro(@Valid RespFiltro requisicao, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "vaga/formulario";
		}
		Vaga curso = requisicao.toCurso();
		List<Vaga> vagas = vagaRepository.findAllByCurso(curso.getCurso());
		model.addAttribute("vagas", vagas);
		return "vaga/filtro";
	}
}
