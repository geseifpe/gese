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
		return "login";
	}

	@RequestMapping("login")
	public String login(Model model, Usuario usuario, HttpSession session) {
		
		String url = null;

		try {
			final UsuarioDao usuarioDao = new UsuarioDao();
			final Usuario usuarioLogado = usuarioDao.login(usuario.getCpf(), Criptografia.md5(usuario.getPassword()));
			
			if(usuarioLogado == null){							
				model.addAttribute("mensagem", Mensagem.MsgLoginIncorreto);
				model.addAttribute("display", "");
				url =  "forward:/";
			} else {				
				
				session.setAttribute("usuario", usuarioLogado);
				
				final CampusDao campusDao = new CampusDao();		
				final List<Campus> listaCampus = campusDao.getCampus();
				
				final CursoDao cursoDao = new CursoDao();		
				final List<Curso> listaCurso = cursoDao.getCursos();
				
				model.addAttribute("listaCampus", listaCampus);
				model.addAttribute("listaCurso", listaCurso);
				
				if(usuarioLogado.getPerfil1().equals("1")) {					
					final AlunoDao alunoDao = new AlunoDao();
					final Aluno aluno = alunoDao.getAlunoId(usuarioLogado.getCpf());
					session.setAttribute("aluno", aluno);
					url = "aluno/aluno";					
				} else if (usuarioLogado.getPerfil2().equals("1")) {
					final PesquisadorDao pesquisadorDao = new PesquisadorDao();
					final Pesquisador pesquisador = pesquisadorDao.getPesquisadorId(usuarioLogado.getCpf());
					session.setAttribute("pesquisador", pesquisador);					
					url = "pesquisador/pesquisador";					
				} else {
					url = "avaliador/avaliador";
				}
			}		
		} catch (Exception e) {
			return "forward:/";
		}		
		return url;
	}	
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
}
