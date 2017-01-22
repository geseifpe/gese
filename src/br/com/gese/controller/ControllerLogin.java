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
		return "inicioTela";
	}
	
	@RequestMapping("/login")
	public String tipoPerfil(Model model, Usuario usuario, HttpSession session) {
		
		String url = null;		

		try {
			
			Usuario usuarioLogado = UsuarioDao.login(usuario.getCpf(), Criptografia.md5(usuario.getPassword()));
			
			if(usuarioLogado == null){							
				model.addAttribute("mensagem", Mensagem.MsgLoginIncorreto);
				model.addAttribute("display", "");
				url = "inicioTela";
			} else {				
				
				session.setAttribute("usuario", usuarioLogado);
				List<Campus> listaCampus = CampusDao.getCampus();			
				List<Curso> listaCurso = CursoDao.getCurso();				
				model.addAttribute("listaCampus", listaCampus);
				model.addAttribute("listaCurso", listaCurso);
				
				if(usuarioLogado.getPerfil1().equals("1")) {					
					Aluno aluno = AlunoDao.getAlunoId(usuarioLogado.getCpf());					
					session.setAttribute("aluno", aluno);
					url = "aluno/aluno";					
				} else if (usuarioLogado.getPerfil2().equals("1")) {					
					Pesquisador pesquisador = PesquisadorDao.getPesquisadorId(usuarioLogado.getCpf());
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
