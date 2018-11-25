package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.RoteiroDao;

@WebServlet("/RemoverRoteiroServlet")
public class RemoverRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverRoteiroServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		RoteiroDao roteiroDao = new RoteiroDao();

		roteiroDao.remove(Long.parseLong(id));

		RequestDispatcher rd = req.getRequestDispatcher("/ListarAdminHorarioRoteiroServlet");
		rd.forward(req, resp);
	}
}