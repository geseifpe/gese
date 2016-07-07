package br.com.gese.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/cadastroAlunoTela")
	public String CadastrarAluno(Model model) {
		CampusDao dao = new CampusDao();
		List<Campus> listaCampus = dao.getCampus();
		
		CursoDao daoCurso = new CursoDao();
		List<Curso> listaCurso = daoCurso.getCurso();
		//List<Campus> listaCampus = dao.getCampusId(8);
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
	    return "telaCadastro/cadastroAlunoTela";
	}
	
	@RequestMapping("/inserirAluno")
	public String inserirAluno(Model model, Aluno aluno, Usuario usuario) {
		AlunoDao dao = new AlunoDao();
		UsuarioDao daoUsuario = new UsuarioDao();
		dao.insertAluno(aluno);
		usuario.setPassword(Criptografia.md5(usuario.getPassword()));
		usuario.setAtivo("1");
		usuario.setPerfil1("1");	
		daoUsuario.insertUsuario(usuario);
		model.addAttribute("mensagem", Mensagem.MsgAlunoInseridoSucesso);
		model.addAttribute("url", "cadastroAlunoTela");
		return "mensagemTela";
	}	
	
	@RequestMapping("/aluno")
	public String aluno(Model model, Aluno aluno) {
		
		CampusDao dao = new CampusDao();
		List<Campus> listaCampus = dao.getCampus();
		
		CursoDao daoCurso = new CursoDao();
		List<Curso> listaCurso = daoCurso.getCurso();
		//List<Campus> listaCampus = dao.getCampusId(8);
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
		model.addAttribute(aluno);
		
		return "telaAluno/aluno";		
	}
	
	@RequestMapping("/updateAluno")
	public String updateAluno(Model model, Aluno aluno) {			
		
		AlunoDao daoAlu = new AlunoDao();
		daoAlu.updateAluno(aluno);

		return "forward:aluno";
	}
		
}

