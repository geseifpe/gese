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
public class ControllerLogin {

	@RequestMapping("/")
	public String inicio(Model model) {
		model.addAttribute("display", "display:none");
		return "telaInicial";
	}
	
	@RequestMapping("/login")
	public String tipoPerfil(Model model, HttpSession session,Usuario usuario) {
		
		String uri = null;		

		try {
			UsuarioDao daoUsuario = new UsuarioDao();			
			Usuario usuarioLogado = daoUsuario.login(usuario.getCpf(), Criptografia.md5(usuario.getPassword()));
			
			if(usuarioLogado == null){							
				model.addAttribute("mensagem", Mensagem.MsgLoginIncorreto);
				model.addAttribute("display", "");
				uri = "telaInicial";
			} else {
				
				session.setAttribute("usuarioLogado", usuarioLogado);
				
				CampusDao daoCampus = new CampusDao();
				List<Campus> listaCampus = daoCampus.getCampus();
				
				CursoDao daoCurso = new CursoDao();
				List<Curso> listaCurso = daoCurso.getCurso();
				
				model.addAttribute("listaCampus", listaCampus);
				model.addAttribute("listaCurso", listaCurso);
				
				if(usuarioLogado.getPerfil1().equals("1")) {					
					AlunoDao daoAluno= new AlunoDao();
					Aluno aluno = daoAluno.getAlunoId(usuarioLogado.getCpf());					
					session.setAttribute("alunoLogado", aluno); 
					model.addAttribute("aluno", aluno);										
					uri = "telaAluno/aluno";
					
				} else if (usuarioLogado.getPerfil2().equals("1")) {
					PesquisadorDao daoPesquisador = new PesquisadorDao();
					Pesquisador pesquisador = daoPesquisador.getPesquisadorId(usuarioLogado.getCpf());
					session.setAttribute("pesquisadorLogado", pesquisador);
					model.addAttribute("pesquisador", pesquisador);					
					uri = "telaPesquisador/pesquisador";
				} else {
					uri = "telaAvaliador/avaliador";
				}
			} 
		
		} catch (Exception e) {
			return "forward:/";
		}		
		return uri;
	}
	
	
	@RequestMapping("/loginAluno")
	public String LoginAluno(Model model, HttpSession session,Usuario usuario) {
		
		String uri = null;		

		try {
			UsuarioDao daoUsuario = new UsuarioDao();			
			Usuario usuarioLogado = daoUsuario.login(usuario.getCpf(), Criptografia.md5(usuario.getPassword()));
			
			if(usuarioLogado == null){							
				model.addAttribute("mensagem", Mensagem.MsgLoginIncorreto);
				model.addAttribute("display", "");
				uri = "telaInicial";
			} else {
				
				session.setAttribute("usuarioLogado", usuarioLogado);
				
				CampusDao daoCampus = new CampusDao();
				List<Campus> listaCampus = daoCampus.getCampus();
				
				CursoDao daoCurso = new CursoDao();
				List<Curso> listaCurso = daoCurso.getCurso();
				
				model.addAttribute("listaCampus", listaCampus);
				model.addAttribute("listaCurso", listaCurso);
				
				if(usuarioLogado.getPerfil1().equals("1")) {					
					AlunoDao daoAluno= new AlunoDao();
					Aluno aluno = daoAluno.getAlunoId(usuarioLogado.getCpf());					
					session.setAttribute("alunoLogado", aluno); 
					model.addAttribute("aluno", aluno);										
					uri = "telaAluno/aluno";
					
				} else if (usuarioLogado.getPerfil2().equals("1")) {
					PesquisadorDao daoPesquisador = new PesquisadorDao();
					Pesquisador pesquisador = daoPesquisador.getPesquisadorId(usuarioLogado.getCpf());
					session.setAttribute("pesquisadorLogado", pesquisador);
					model.addAttribute("pesquisador", pesquisador);					
					uri = "telaPesquisador/pesquisador";
				} else {
					uri = "telaAvaliador/avaliador";
				}
			} 
		
		} catch (Exception e) {
			return "forward:/";
		}		
		return uri;
	}
	
//	@RequestMapping("/loginPesquisador")
//	public String LoginPesquisador(Model model, HttpSession session,Usuario usuario) {
//		String uri = null;
//		try {
//			PesquisadorDao daoPesquisador= new PesquisadorDao();
//			UsuarioDao daoUsuario = new UsuarioDao();
//			Usuario usuarioLogado = daoUsuario.login(usuario.getCpf(), Criptografia.md5(usuario.getPassword()));
//			if(usuarioLogado == null){				
//				model.addAttribute("mensagem", Mensagem.MsgLoginIncorreto);
//				model.addAttribute("display", "");
//				uri = "telaInicial";
//			}else{
//				Pesquisador pesquisador = daoPesquisador.getPesquisadorId(usuarioLogado.getCpf());
//				session.setAttribute("usuarioLogado", usuarioLogado); 
//				session.setAttribute("pesquisadorLogado", pesquisador); 
//				model.addAttribute("pesquisador", pesquisador);
//				uri = "telaPesquisador/pesquisador";
//			}
//		} catch (Exception e) {
//			return "forward:/";
//		}
//		return uri;
//	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
}
