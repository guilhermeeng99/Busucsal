package br.ucsal.cliente.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.cliente.dao.HorarioDao;
import br.ucsal.cliente.model.Horario;

@WebServlet("/InserirHorario")
public class InserirHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InserirHorario() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Horario Horario = new Horario();

		String roteiro = request.getParameter("roteiro");
		String data = request.getParameter("data");
		String horario = request.getParameter("horario");

		Horario.setRoteiro(roteiro);
		Horario.setData(data);
		Horario.setHorario(horario);

		HorarioDao HorarioDao;
		
		try {
			HorarioDao = new HorarioDao();
			HorarioDao.adiciona(Horario);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/administrador.jsp");

	}

}