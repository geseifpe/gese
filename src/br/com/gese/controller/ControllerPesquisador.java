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
		
		List<Campus> listaCampus = CampusDao.getCampus();			
		List<Curso> listaCurso = CursoDao.getCurso();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
	    return "pesquisador/cadastroPesquisadorTela";
	}
	
	@RequestMapping("/inserirPesquisador")
	public String inserirPesquisador(Model model, Pesquisador pesquisador, Usuario usuario) {
						
		PesquisadorDao.insertPesquisador(pesquisador);
		usuario.setPassword(Criptografia.md5(usuario.getPassword()));
		usuario.setAtivo("1");
		usuario.setPerfil2("1");
		UsuarioDao.insertUsuario(usuario);
		
		model.addAttribute("mensagem", Mensagem.MsgPesquisadorInseridoSucesso);
		model.addAttribute("url", "cadastroPesquisador");
		
		return "mensagemTela";
	}	
	
	@RequestMapping("/updatePesquisador")
	public String updatePesquisador(Model model, Pesquisador pesquisador) {			
						
		List<Campus> listaCampus = CampusDao.getCampus();			
		List<Curso> listaCurso = CursoDao.getCurso();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
		PesquisadorDao.updatePesquisador(pesquisador);
		
		return "pesquisador/pesquisador";
	}	
	
	@RequestMapping(value = "/submeterProjeto", method = RequestMethod.POST)	
	public String submeterProjeto(@RequestParam("input2[]") MultipartFile[] files, HttpSession session) {					
		new Upload().uploadSubmissaoProjeto(files, session);		
		return "pesquisador/pesquisador";
	}		
}
