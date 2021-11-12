package br.com.opet.lifeinvader.dto;

import javax.validation.constraints.NotBlank;

import br.com.opet.lifeinvader.model.Vaga;

public class RespFiltro {
	
	@NotBlank
	private String curso;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public Vaga toCurso() {
		Vaga vaga = new Vaga();
		vaga.setCurso(curso);
		return vaga;
	}

}
