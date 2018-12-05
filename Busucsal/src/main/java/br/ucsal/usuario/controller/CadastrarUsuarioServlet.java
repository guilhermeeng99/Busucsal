package br.ucsal.usuario.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.busucsal.dao.UsuarioDao;
import br.ucsal.busucsal.model.Usuario;

@WebServlet("/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarUsuarioServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = new Usuario();

		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.adiciona(usuario);
		usuarioDao.login(usuario);
		Usuario usuarioLogin = usuarioDao.login(usuario);
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogin", usuarioLogin);
		response.sendRedirect("/ListarUsuarioHorarioRoteiroServlet");

	}

}