package br.com.caelum.tarefa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		
		String uri = request.getRequestURI();
		
		//  Conteudos liberado pelo Interceptor Adapter
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}

		// Checa se existe no sistema um objeto do tipo sessao com valor setado usuarioLogado
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		response.sendRedirect("loginForm");
		return false;
	}
}
