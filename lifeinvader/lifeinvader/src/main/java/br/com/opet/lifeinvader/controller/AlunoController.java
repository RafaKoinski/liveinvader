package br.com.opet.lifeinvader.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.opet.lifeinvader.dto.RespUser;
import br.com.opet.lifeinvader.model.Authority;
import br.com.opet.lifeinvader.model.Usuario;
import br.com.opet.lifeinvader.repository.AuthorityRepository;
import br.com.opet.lifeinvader.repository.UserRepository;

@Controller
@RequestMapping("cadastrar")
public class AlunoController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	//Existe uma anotação chamada de “@ExceptionHandler”, onde nós passamos qual é a
    // exceção que queremos mapear. É a “IllegalArgumentException”
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/login";
    }

	@GetMapping
	public String cadastro(RespUser requisicao) {
		return "cadastrar";
	}
	
	@PostMapping("novo")
	public String cadastro(@Valid RespUser requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "cadastrar";
		}
		
		Usuario aluno = requisicao.toUsuario();
		Authority auth = new Authority();
		auth.setAuthority("ROLE_ADM"); 
		auth.setUsername(aluno.getUsername());
		userRepository.save(aluno);
		authorityRepository.save(auth);
		return "redirect:/login";
		
	}


}
	//*******************************************************************
	//*******************************************************************

/*  @PostMapping("novo")
    public String cadastrar(@Valid RespUser requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastrar";
        }
        
        User aluno = requisicao.toUser(); 
        userRepository.save(aluno);

        return "redirect:/login";
    } */
	
