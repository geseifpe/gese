package br.com.gese.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		boolean acesso = false;
		String uri = request.getRequestURI();
		if (uri.startsWith("/gese/resources") || uri.endsWith("/cadastroPesquisador")
			|| uri.endsWith("/cadastroAluno") || uri.endsWith("/login") || uri.endsWith("/")
			|| uri.endsWith("/aluno/") || uri.endsWith("/pesquisador/") || uri.endsWith("/inserirAluno")
			|| uri.endsWith("/inserirPesquisador") || uri.endsWith("/updateAluno")
			|| uri.endsWith("/updatePesquisador") || uri.endsWith("/uploadMultipleFile")
			|| uri.endsWith("/uploadFile") || uri.endsWith("/submeterProjeto") || uri.endsWith("logout")) {

			acesso = true;

		} else {
			if (request.getSession().getAttribute("usuarioLogado") != null) {
				request.getSession().getAttribute("usuarioLogado");
				acesso = true;
			} else {
				if (!acesso && request.getSession().getAttribute("usuarioLogado") == null && (uri.endsWith("/login"))) {
					response.sendRedirect("/gese/");

				}
			}
		}
		return acesso;

	}

}
