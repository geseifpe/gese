package br.com.gese.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gese.dao.CampusDao;
import br.com.gese.model.Campus;

@Controller
public class ControllerCampus {
	
	@RequestMapping("/listarCampus")
	public String listarCampus(Model model) {
		
		List<Campus> listaCampus = CampusDao.getCampus();
		model.addAttribute("listaCampus", listaCampus);
	    return "campus";
	}
	
	@RequestMapping("/inserirCampus")
	public String inserirCampus(Model model, Campus campus) {
		
		CampusDao.insertCampus(campus);
		model.addAttribute("mensagem", "Campus inserido com sucesso");
	    return "forward:listarCampus";
	}
}
