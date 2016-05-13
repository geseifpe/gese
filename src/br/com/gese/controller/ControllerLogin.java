package br.com.gese.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gese.dao.AlunoDao;
import br.com.gese.dao.UsuarioDao;
import br.com.gese.model.Aluno;
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

	@RequestMapping("/tipologin")
	public String TipoLogin() {

		return "tipoLogin";
	}

	@RequestMapping("/aluno")
	public String LoginAluno() {

		return "telaAluno/aluno";
	}

	@RequestMapping("/pesquisador")
	public String LoginPesquisador() {

		return "telaPesquisador/pesquisador";
	}

	@RequestMapping("/avaliador")
	public String LoginAvaliador() {

		return "telaAvaliador/avaliador";
	}

	@RequestMapping("/loginAluno")
	public String LoginAluno(Model model, Usuario usuario) {

        AlunoDao daoAluno= new AlunoDao();
		UsuarioDao daoUsuario = new UsuarioDao();
		Usuario usuarioLogado = daoUsuario.login(usuario.getCpf(), Criptografia.md5(usuario.getPassword()));
		if(usuarioLogado == null){
			model.addAttribute("mensagem", Mensagem.MsgLoginIncorreto);
			model.addAttribute("display", "");
			return "telaInicial";
		}else{
			Aluno aluno = daoAluno.getAlunoId(usuarioLogado.getCpf());
			model.addAttribute("aluno", aluno);
			return "telaAluno/aluno";
		}

	}
}
