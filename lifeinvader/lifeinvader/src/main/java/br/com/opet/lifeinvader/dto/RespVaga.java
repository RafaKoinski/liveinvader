package br.com.opet.lifeinvader.dto;

import javax.validation.constraints.NotBlank;

import br.com.opet.lifeinvader.model.Vaga;

public class RespVaga {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String curso;
	
	@NotBlank
	private String url;
	private String descricao;
	

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Vaga toVaga() {
		Vaga vaga = new Vaga();
		vaga.setTitulo(titulo);
		vaga.setUrl(url);
		vaga.setDescricao(descricao);
		vaga.setCurso(curso);
		return vaga;
	}

}
