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

@WebServlet("/RemoverHorario")
public class RemoverHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverHorario() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Horario horario = new Horario();

		String roteiro= request.getParameter("roteiro");

		horario.setRoteiro(roteiro);

		HorarioDao HorarioDao;
		

		try {
			HorarioDao = new HorarioDao();
			HorarioDao.remove(horario);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/administrador.jsp");

	}

}