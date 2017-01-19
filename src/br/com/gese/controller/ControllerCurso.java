package br.com.gese.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gese.dao.CursoDao;
import br.com.gese.model.Curso;

@Controller
public class ControllerCurso {
	
	@RequestMapping("/listarCurso")
	public String listarCampus(Model model) {
		
		List<Curso> listaCurso = CursoDao.getCurso();
		model.addAttribute("listaCurso", listaCurso);
	    return "curso";
	}
	
	@RequestMapping("/inserirCurso")
	public String inserirCampus(Model model, Curso curso) {
		
		CursoDao.insertCurso(curso);
		model.addAttribute("mensagem", "Curso inserido com sucesso");
	    return "forward:listarCurso";
	}
}
