package br.com.gese.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class ControllerPesquisador {
	
	@RequestMapping("/cadastroPesquisador")
	public String CadastroPesquisador(Model model) {		
		
		List<Campus> listaCampus = CampusDao.getCampus();			
		List<Curso> listaCurso = CursoDao.getCurso();
		
		model.addAttribute("listaCampus", listaCampus);
		model.addAttribute("listaCurso", listaCurso);
		
	    return "telaCadastro/cadastroPesquisadorTela";
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
		
		return "telaPesquisador/pesquisador";
	}
	
	@RequestMapping(value = "/submeterProjeto", method = RequestMethod.POST)	
	public String submeterProjeto(@RequestParam("input2[]") MultipartFile[] files) {	
		
		final Logger logger = LoggerFactory.getLogger(ControllerPesquisador.class);
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = files[i].getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "F:/Eclipse EE/gese_maven/src/main/webapp/resources";
				File dir = new File(rootPath + File.separator + "arquivos");
				
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name + "";
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
				return "error";
			}			
		}		
		
		return "telaPesquisador/pesquisador";
	}						
		
}
