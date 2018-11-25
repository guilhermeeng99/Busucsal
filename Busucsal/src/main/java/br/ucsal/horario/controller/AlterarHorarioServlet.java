package br.ucsal.horario.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.horario.dao.HorarioDao;
import br.ucsal.horario.model.Horario;

@WebServlet("/AlterarHorarioServlet")
public class AlterarHorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarHorarioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		HorarioDao horarioDao = new HorarioDao();

		Horario horario = horarioDao.getHorario(Long.parseLong(id));

		req.setAttribute("horario", horario);
		RequestDispatcher rd = req.getRequestDispatcher("alterarHorario.jsp");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Horario horarios = new Horario();
		
		String id = request.getParameter("id");
		String horario = request.getParameter("horario");
		String data = request.getParameter("data");
		String roteiro = request.getParameter("roteiro");

		horarios.setId(Long.parseLong(id));
		horarios.setHorario(horario);
		horarios.setData(data);
		horarios.setRoteiro(roteiro);

		HorarioDao horarioDao;

		horarioDao = new HorarioDao();
		horarioDao.altera(horarios);

		response.sendRedirect("/ListarAdminHorarioRoteiroServlet");
	}

}