package br.ucsal.horario.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.HorarioDao;

@WebServlet("/RemoverHorarioServlet")
public class RemoverHorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverHorarioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		HorarioDao horarioDao = new HorarioDao();

		horarioDao.remove(Long.parseLong(id));

		RequestDispatcher rd = req.getRequestDispatcher("/ListarAdminHorarioRoteiroServlet");
		rd.forward(req, resp);
	}
}