package br.ucsal.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.admin.dao.AdminDao;
import br.ucsal.admin.model.Admin;

@WebServlet("/AlterarAdminServlet")
public class AlterarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarAdminServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		AdminDao adminDao = new AdminDao();

		Admin admin = adminDao.getAdmin(Long.parseLong(id));

		HttpSession sessao = req.getSession();
		sessao.setAttribute("adminAntigo", admin);
		RequestDispatcher rd = req.getRequestDispatcher("alterarAdmin.jsp");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Admin admin = new Admin();
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		admin.setNome(nome);
		admin.setLogin(login);
		admin.setSenha(senha);
		AdminDao adminDao = new AdminDao();
		admin.setId(adminDao.getId(admin,(Admin) sessao.getAttribute("adminAntigo")));
		adminDao.altera(admin);
		
		sessao.setAttribute("adminLogin", admin);

		response.sendRedirect("/ListarAdminServlet");
	}

}