package br.com.gese.controller;

import java.util.List;

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

	@RequestMapping("/cadastroAluno")
	public String CadastrarAluno(Model model) {

		final CampusDao campusDao = new CampusDao();
		final List<Campus> listaCampus = campusDao.getCampus();

		final CursoDao cursoDao = new CursoDao();
		final List<Curso> listaCurso = cursoDao.getCursos();

		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);

		return "aluno/cadastroAluno";
	}

	@RequestMapping("/inserirAluno")
	public String inserirAluno(Model model, Aluno aluno, Usuario usuario) {
		
		final AlunoDao alunoDao = new AlunoDao();
		alunoDao.insertAluno(aluno);

		usuario.setPassword(Criptografia.md5(usuario.getPassword()));
		usuario.setAtivo("1");
		usuario.setPerfil1("1");

		final UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.insertUsuario(usuario);

		model.addAttribute("mensagem", Mensagem.MsgAlunoInseridoSucesso);
		model.addAttribute("url", "login");
		return "mensagemTela";
	}

	@RequestMapping("/updateAluno")
	public String updateAluno(Model model, Aluno aluno) {

		final AlunoDao alunoDao = new AlunoDao();
		alunoDao.updateAluno(aluno);

		final CampusDao campusDao = new CampusDao();
		List<Campus> listaCampus = campusDao.getCampus();

		final CursoDao cursoDao = new CursoDao();
		List<Curso> listaCurso = cursoDao.getCursos();

		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);

		return "aluno/aluno";
	}
}
