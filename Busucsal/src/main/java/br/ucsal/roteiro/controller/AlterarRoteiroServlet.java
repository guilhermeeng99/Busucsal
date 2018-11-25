package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.RoteiroDao;
import br.ucsal.roteiro.model.Roteiro;

@WebServlet("/AlterarRoteiroServlet")
public class AlterarRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarRoteiroServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		RoteiroDao roteiroDao = new RoteiroDao();

		Roteiro roteiro = roteiroDao.getRoteiro(Long.parseLong(id));

		req.setAttribute("roteiro", roteiro);
		RequestDispatcher rd = req.getRequestDispatcher("alterarRoteiro.jsp");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Roteiro roteiros = new Roteiro();
		
		String id = request.getParameter("id");
		String rota = request.getParameter("rota");
		String saida = request.getParameter("saida");
		String parada = request.getParameter("parada");

		roteiros.setId(Long.parseLong(id));
		roteiros.setRota(rota);
		roteiros.setSaida(saida);
		roteiros.setParada(parada);

		RoteiroDao roteiroDao;

		roteiroDao = new RoteiroDao();
		roteiroDao.altera(roteiros);

		response.sendRedirect("/ListarAdminHorarioRoteiroServlet");
	}

}