package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.RoteiroDao;
import br.ucsal.roteiro.model.Roteiro;

@WebServlet("/CadastrarRoteiroServlet")
public class CadastrarRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarRoteiroServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Roteiro roteiros = new Roteiro();

		String rota = request.getParameter("rota");
		String saida = request.getParameter("saida");
		String parada = request.getParameter("parada");

		roteiros.setRota(rota);
		roteiros.setSaida(saida);
		roteiros.setParada(parada);

		RoteiroDao roteiroDao;

		roteiroDao = new RoteiroDao();
		roteiroDao.adiciona(roteiros);

		response.sendRedirect("/ListarAdminHorarioRoteiroServlet");

	}

}