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

@WebServlet("/AlterarRota")
public class AlterarRota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarRota() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Rota Rota = new Rota();

		String roteiro = request.getParameter("roteiro");
		String saida = request.getParameter("saida");
		String paradas = request.getParameter("paradas");

		Rota.setSaida(saida);
		Rota.setParadas(paradas);
		Rota.setRoteiro(roteiro);

		RotaDao RotaDao;
		
		try {
			RotaDao = new RotaDao();
			RotaDao.altera(Rota);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/administrador.jsp");

	}

}