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
	
	public void uploadSubmissaoProjeto(final MultipartFile[] files, HttpSession session) {			
		
		final Logger logger = LoggerFactory.getLogger(ControllerPesquisador.class);
		String message = "";			
		final String cpf = ((Pesquisador) session.getAttribute("pesquisador")).getCpf();
		
		for (int i = 0; i < files.length; i++) {
			final MultipartFile file = files[i];
			final String name = files[i].getOriginalFilename();
			
			try {				
				
				final byte[] bytes = file.getBytes();
				
				final File dir = new File(session.getServletContext().getRealPath("/view/pesquisador/uploads/" + cpf));
				System.out.println("Diretorio existe: " + dir.exists());
				if (!dir.exists())
					dir.mkdirs();
 
				final File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				final BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Localização do serverFile=" + serverFile.getAbsolutePath());

				message = message + "Upload completo do arquivo=" + name + "";
			} catch (Exception e) {
				System.out.println("Falha ao fazer o upload do arquivo " + name + " => " + e.getMessage());		
			}			
		}				
	}
}

