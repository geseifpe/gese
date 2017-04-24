package br.com.gese.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.gese.dao.CampusDao;
import br.com.gese.dao.CursoDao;
import br.com.gese.dao.PesquisadorDao;
import br.com.gese.dao.UsuarioDao;
import br.com.gese.model.Campus;
import br.com.gese.model.Curso;
import br.com.gese.model.Pesquisador;
import br.com.gese.model.Usuario;
import br.com.gese.util.Criptografia;
import br.com.gese.util.Mensagem;
import br.com.gese.util.Upload;

@Controller
public class ControllerPesquisador {	
	
	@RequestMapping("/cadastroPesquisador")
	public String CadastroPesquisador(Model model) {		
		
		final CampusDao campusDao = new CampusDao();		
		final List<Campus> listaCampus = campusDao.getCampus();
		
		final CursoDao cursoDao = new CursoDao();		
		final List<Curso> listaCurso = cursoDao.getCursos();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
	    return "pesquisador/cadastroPesquisador";
	}
	
	@RequestMapping("/inserirPesquisador")
	public String inserirPesquisador(Model model, Pesquisador pesquisador, Usuario usuario) {
		
		final PesquisadorDao pesquisadorDao = new PesquisadorDao();		
		pesquisadorDao.insertPesquisador(pesquisador);
		
		usuario.setPassword(Criptografia.md5(usuario.getPassword()));
		usuario.setAtivo("1");
		usuario.setPerfil2("1");
		
		final UsuarioDao usuarioDao = new UsuarioDao();		
		usuarioDao.insertUsuario(usuario);
		
		model.addAttribute("mensagem", Mensagem.MsgPesquisadorInseridoSucesso);
		model.addAttribute("url", "login");
		
		return "mensagemTela";
	}	
	
	@RequestMapping("/updatePesquisador")
	public String updatePesquisador(Model model, Pesquisador pesquisador) {			
						
		final CampusDao campusDao = new CampusDao();		
		final List<Campus> listaCampus = campusDao.getCampus();
		
		final CursoDao cursoDao = new CursoDao();		
		final List<Curso> listaCurso = cursoDao.getCursos();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
		final PesquisadorDao pesquisadorDao = new PesquisadorDao();
		pesquisadorDao.updatePesquisador(pesquisador);
		
		return "pesquisador/pesquisador";
	}	
	
	@RequestMapping(value = "/submeterProjeto", method = RequestMethod.POST)	
	public String submeterProjeto(@RequestParam("input2[]") MultipartFile[] files, HttpSession session) {					
		new Upload().uploadSubmissaoProjeto(files, session);		
		return "pesquisador/pesquisador";
	}		
}
