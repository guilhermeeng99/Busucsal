package br.ucsal.horario.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.horario.model.Horario;
import br.ucsal.horario.dao.HorarioDao;

@WebServlet("/CadastrarHorarioServlet")
public class CadastrarHorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarHorarioServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Horario horarios = new Horario();

		String horario = request.getParameter("horario");
		String data = request.getParameter("data");
		String roteiro = request.getParameter("roteiro");

		horarios.setHorario(horario);
		horarios.setData(data);
		horarios.setRoteiro(roteiro);

		HorarioDao horarioDao;

		horarioDao = new HorarioDao();
		horarioDao.adiciona(horarios);

		response.sendRedirect("/ListarAdminHorarioRoteiroServlet");

	}

}