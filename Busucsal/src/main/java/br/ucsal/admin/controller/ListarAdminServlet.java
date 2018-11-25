package br.ucsal.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.admin.dao.AdminDao;

@WebServlet("/ListarAdminServlet")
public class ListarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarAdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDao adminDao = new AdminDao();

			request.setAttribute("admin", adminDao.getLista());
			RequestDispatcher rd = request.getRequestDispatcher("listarAdmin.jsp");
			rd.forward(request, response);

	}

}