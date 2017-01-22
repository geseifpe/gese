package br.com.gese.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import br.com.gese.controller.ControllerPesquisador;
import br.com.gese.model.Pesquisador;

/**
 * Servlet implementation class SubmeterProjeto
 */

public class Upload {		
	
	public void uploadSubmissaoProjeto(MultipartFile[] files, HttpSession session) {			
		
		final Logger logger = LoggerFactory.getLogger(ControllerPesquisador.class);
		String message = "";			
		String cpf = ((Pesquisador) session.getAttribute("pesquisador")).getCpf();
		
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = files[i].getOriginalFilename();
			
			try {				
				
				byte[] bytes = file.getBytes();
				
				File dir = new File(session.getServletContext().getRealPath("/view/pesquisador/uploads/" + cpf));
				System.out.println("Diretorio existe: " + dir.exists());
				if (!dir.exists())
					dir.mkdirs();
 
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name + "";
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());		
			}			
		}				
	}
}

