package br.ucsal.cliente.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.cliente.model.Admin;

@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin user = new Admin(null, null);
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		user.setLogin(login);
		user.setSenha(senha);
		if (autenticarUser(user)) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("administrador.jsp");
		} else {
			request.setAttribute("erro", "Usuario ou senha invalios!");
			RequestDispatcher d = request.getRequestDispatcher("paginaErro.jsp");
			d.forward(request, response);
		}
	}

	private boolean autenticarUser(Admin user) {
		boolean autenticado = false;
		if (user.getLogin().equals("guilherme") && user.getSenha().equals("123")){
			autenticado = true;
		}
		return autenticado;
	}

}

