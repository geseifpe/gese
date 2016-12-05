package br.com.gese.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.gese.model.Usuario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
				throws Exception {
		boolean acesso = false;
		String uri = request.getRequestURI();
		if (uri.contains("/resources/bootstrap") || uri.contains("/resources/css") || uri.contains("/resources/img")
				|| uri.contains("/resources/js") || uri.endsWith("/cadastroPesquisador") || uri.endsWith("/cadastroAluno") 
				|| uri.endsWith("/telainicial") || uri.endsWith("/login")|| uri.endsWith("/")
				|| uri.endsWith("/telaAluno/aluno")|| uri.endsWith("/inserirAluno") || uri.endsWith("/updateAluno")
				|| uri.endsWith("/uploadMultipleFile") || uri.endsWith("/uploadFile") || uri.endsWith("/inserirPesquisador")
				|| uri.endsWith("/updatePesquisador") || uri.endsWith("/submeterProjeto") || uri.endsWith("logout")) {
			
				 acesso = true;
			
			
		}else{
			if (request.getSession().getAttribute("usuarioLogado") != null) {
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
				acesso = true;
			}else{
				if (!acesso && request.getSession().getAttribute("usuarioLogado") == null && (uri.endsWith("/login") ) ) {
					response.sendRedirect("/gese/");
					
				}
			}
		}
		return acesso;
		
		
	}
	
	
	
}
