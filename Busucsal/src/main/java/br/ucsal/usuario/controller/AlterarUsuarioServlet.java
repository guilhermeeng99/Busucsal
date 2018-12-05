package br.ucsal.usuario.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.busucsal.dao.UsuarioDao;
import br.ucsal.busucsal.model.Usuario;

@WebServlet("/AlterarUsuarioServlet")
public class AlterarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarUsuarioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		UsuarioDao usuarioDao = new UsuarioDao();

		Usuario usuario = usuarioDao.getUsuario(Long.parseLong(id));

		HttpSession sessao = req.getSession();
		sessao.setAttribute("usuarioAntigo", usuario);
		RequestDispatcher rd = req.getRequestDispatcher("alterarUsuario.jsp");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = new Usuario();
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		UsuarioDao usuarioDao = new UsuarioDao();
		usuario.setId(usuarioDao.getId(usuario,(Usuario) sessao.getAttribute("usuarioAntigo")));
		usuarioDao.altera(usuario);
		
		sessao.setAttribute("usuarioLogin", usuario);

		response.sendRedirect("/ListarUsuarioServlet");
	}

}