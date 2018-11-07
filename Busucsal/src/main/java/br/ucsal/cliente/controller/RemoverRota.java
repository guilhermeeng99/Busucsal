package br.ucsal.cliente.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.cliente.dao.RotaDao;
import br.ucsal.cliente.model.Rota;

@WebServlet("/RemoverRota")
public class RemoverRota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverRota() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Rota rota = new Rota();

		String roteiro = request.getParameter("roteiro");

		rota.setRoteiro(roteiro);

		RotaDao RotaDao;
		
		try {
			RotaDao = new RotaDao();
			RotaDao.remove(rota);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/administrador.jsp");

	}

}