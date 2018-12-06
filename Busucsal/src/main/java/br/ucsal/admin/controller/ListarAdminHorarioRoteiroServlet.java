package br.ucsal.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.HorarioDao;
import br.ucsal.busucsal.dao.RoteiroDao;
import br.ucsal.busucsal.dao.UsuarioDao;

@WebServlet("/ListarAdminHorarioRoteiroServlet")
public class ListarAdminHorarioRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarAdminHorarioRoteiroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HorarioDao horarioDao = new HorarioDao();
		RoteiroDao roteiroDao = new RoteiroDao();
		UsuarioDao usuarioDao = new UsuarioDao();

		request.setAttribute("usuario", usuarioDao.getLista());
		request.setAttribute("roteiro", roteiroDao.getLista());
		request.setAttribute("horario", horarioDao.getLista());
		RequestDispatcher rd = request.getRequestDispatcher("listarAdminHorarioRoteiro.jsp");
		rd.forward(request, response);
	}

}