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

@WebServlet("/LogarAdminServlet")
public class LogarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogarAdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if (sessao != null) {
			sessao.invalidate();

		}
		response.sendRedirect("loginAdmin.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Admin admin = new Admin();
		admin.setLogin(login);
		admin.setSenha(senha);

		AdminDao adminDao = new AdminDao();

		Admin adminLogin = adminDao.login(admin);
		if (adminLogin != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("adminLogin", adminLogin);
			response.sendRedirect("/ListarAdminHorarioRoteiroServlet");

		} else {
			request.setAttribute("erro", "Login ou Senha invalidos");
			request.getRequestDispatcher("erroLoginAdmin.jsp").forward(request, response);
			;
		}

	}

}