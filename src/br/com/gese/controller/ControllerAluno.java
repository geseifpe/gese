package br.com.gese.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gese.dao.AlunoDao;
import br.com.gese.dao.CampusDao;
import br.com.gese.dao.CursoDao;
import br.com.gese.dao.UsuarioDao;
import br.com.gese.model.Aluno;
import br.com.gese.model.Campus;
import br.com.gese.model.Curso;
import br.com.gese.model.Usuario;
import br.com.gese.util.Criptografia;
import br.com.gese.util.Mensagem;

@Controller
public class ControllerAluno {

	@RequestMapping("/cadastroAluno")
	public String CadastrarAluno(Model model) {
	
		List<Campus> listaCampus = CampusDao.getCampus();			
		List<Curso> listaCurso = CursoDao.getCurso();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
	    return "aluno/cadastroAluno";
	}
		
	@RequestMapping(value = "/inserirAluno", method = RequestMethod.POST)	
	public String inserirAluno(Model model, Aluno aluno, Usuario usuario,
			@RequestParam("nascimento") @DateTimeFormat(iso = ISO.DATE) LocalDate nascimento) {		
				
		aluno.setNascimento(nascimento);		
		AlunoDao.insertAluno(aluno);
		
		usuario.setPassword(Criptografia.md5(usuario.getPassword()));
		usuario.setAtivo("1");
		usuario.setPerfil1("1");	
		UsuarioDao.insertUsuario(usuario);
		
		model.addAttribute("mensagem", Mensagem.MsgAlunoInseridoSucesso);
		model.addAttribute("url", "/");
		return "mensagemTela";
	}
	
	@RequestMapping("/updateAluno")
	public String updateAluno(Model model, Aluno aluno) {		
		
		AlunoDao.updateAluno(aluno);
		
		List<Campus> listaCampus = CampusDao.getCampus();			
		List<Curso> listaCurso = CursoDao.getCurso();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
		return "aluno/aluno";
	}			
}

