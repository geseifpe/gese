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
				|| uri.contains("/resources/js") || uri.endsWith("/Projeto_Final/") || uri.endsWith("logout")
				|| uri.endsWith("/telaAluno/aluno")|| uri.endsWith("/telainicial") || uri.endsWith("/")) {
			
				 acesso = true;
			
			
		}else{
			if (request.getSession().getAttribute("usuarioLogado") != null) {
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
				acesso = true;
			}else{
				if (!acesso && request.getSession().getAttribute("usuarioLogado") == null && (uri.endsWith("loginAluno") ) ) {
					acesso = true;
				}
			}
		}
		return acesso;
		
		
	}
	
	
	
}
