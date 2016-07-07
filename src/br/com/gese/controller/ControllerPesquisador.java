package br.com.gese.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gese.dao.AlunoDao;
import br.com.gese.dao.CampusDao;
import br.com.gese.dao.CursoDao;
import br.com.gese.dao.PesquisadorDao;
import br.com.gese.dao.UsuarioDao;
import br.com.gese.model.Aluno;
import br.com.gese.model.Campus;
import br.com.gese.model.Curso;
import br.com.gese.model.Pesquisador;
import br.com.gese.model.Usuario;
import br.com.gese.util.Criptografia;
import br.com.gese.util.Mensagem;

@Controller
public class ControllerPesquisador {
	
	@RequestMapping("/cadastroPesquisadorTela")
	public String CadastroPesquisador(Model model) {
		CampusDao dao = new CampusDao();
		List<Campus> listaCampus = dao.getCampus();
		
		CursoDao daoCurso = new CursoDao();
		List<Curso> listaCurso = daoCurso.getCurso();
		//List<Campus> listaCampus = dao.getCampusId(8);
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
	    return "telaCadastro/cadastroPesquisadorTela";
	}
	
	@RequestMapping("/inserirPesquisador")
	public String inserirPesquisador(Model model, Pesquisador pesquisador, Usuario usuario) {
		
		PesquisadorDao dao = new PesquisadorDao();
		UsuarioDao daoUsuario = new UsuarioDao();
		dao.insertPesquisador(pesquisador);
		usuario.setPassword(Criptografia.md5(usuario.getPassword()));
		usuario.setAtivo("1");
		usuario.setPerfil2("1");
		daoUsuario.insertUsuario(usuario);
		model.addAttribute("mensagem", Mensagem.MsgPesquisadorInseridoSucesso);
		model.addAttribute("url", "cadastroPesquisadorTela");
		return "mensagemTela";
	}
	
	@RequestMapping("/updatePesquisador")
	public String updateAluno(Model model, Pesquisador pesquisador) {		
		
		PesquisadorDao daoPesq = new PesquisadorDao();	
		daoPesq.updatePesquisador(pesquisador);
		
		return "forward:pesquisador";
	}
	
	@RequestMapping("/pesquisador")
	public String aluno(Model model, Pesquisador pesquisador) {
		
		CampusDao dao = new CampusDao();
		List<Campus> listaCampus = dao.getCampus();
		
		CursoDao daoCurso = new CursoDao();
		List<Curso> listaCurso = daoCurso.getCurso();
		//List<Campus> listaCampus = dao.getCampusId(8);
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
		model.addAttribute(pesquisador);
		
		return "telaPesquisador/pesquisador";		
	}
	
	
		
}
