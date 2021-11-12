package br.com.opet.lifeinvader.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.opet.lifeinvader.model.Usuario;

public class RespUser {
	
	
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private Boolean enabled;
    
    @NotBlank
	private String nome;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String curso;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
		
	public Usuario toUsuario(){
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setPassword(new BCryptPasswordEncoder().encode(password));
		usuario.setEnabled(true);
		usuario.setNome(nome);
		usuario.setCurso(curso);
		usuario.setEmail(email);
		return usuario;
	}
	
	

    
 }