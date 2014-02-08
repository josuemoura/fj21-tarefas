package br.com.caelum.tarefa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefa.dao.UsuarioDAO;
import br.com.caelum.tarefa.modelo.Usuario;

@Controller
public class LoginController {
	
	private static UsuarioDAO dao;
	
	@Autowired
	public LoginController(UsuarioDAO dao) {
		this.dao = dao;
	}

	// Carrega a página de login
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	// Verifica se usuario existe
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (dao.existeUsuario(usuario)) {
			// Cria uma sessao e seta valor usuarioLogado
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "forward:loginForm";
	}
	
	// Encerra a sessao e redireciona para pagina de login
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"forward:loginForm";
	}
}
