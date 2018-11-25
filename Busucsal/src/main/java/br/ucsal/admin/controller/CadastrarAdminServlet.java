package br.ucsal.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.admin.dao.AdminDao;
import br.ucsal.admin.model.Admin;

@WebServlet("/CadastrarAdminServlet")
public class CadastrarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarAdminServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Admin admin = new Admin();

		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		admin.setNome(nome);
		admin.setLogin(login);
		admin.setSenha(senha);

		AdminDao adminDao = new AdminDao();
		adminDao.adiciona(admin);
		adminDao.login(admin);
		Admin adminLogin = adminDao.login(admin);
		HttpSession sessao = request.getSession();
		sessao.setAttribute("adminLogin", adminLogin);
		response.sendRedirect("/ListarAdminHorarioRoteiroServlet");

	}

}