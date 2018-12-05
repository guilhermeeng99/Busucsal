package br.ucsal.usuario.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.HorarioDao;
import br.ucsal.busucsal.dao.RoteiroDao;

@WebServlet("/ListarUsuarioHorarioRoteiroServlet")
public class ListarUsuarioHorarioRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarUsuarioHorarioRoteiroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HorarioDao horarioDao = new HorarioDao();
		RoteiroDao roteiroDao = new RoteiroDao();
		
		request.setAttribute("roteiro", roteiroDao.getLista());
		request.setAttribute("horario", horarioDao.getLista());
		RequestDispatcher rd = request.getRequestDispatcher("listarUsuarioHorarioRoteiro.jsp");
		rd.forward(request, response);
	}

}