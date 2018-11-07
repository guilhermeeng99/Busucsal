package br.ucsal.cliente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.cliente.model.Horario;

public class HorarioDao {

	private Connection connection;

	public HorarioDao() throws SQLException, ClassNotFoundException {
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Horario horario) {
		String sql = "insert into horario " + "(roteiro,data,horario)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, horario.getRoteiro());
			stmt.setString(2, horario.getData());
			stmt.setString(3, horario.getHorario());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Horario horario) throws SQLException {

		String sql = "delete from horario where roteiro=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, horario.getRoteiro());
		stmt.execute();
		stmt.close();

	}

	public void altera(Horario horario) throws SQLException {
		String sql = "update horario set data=?, horario=? where roteiro=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, horario.getData());
		stmt.setString(2, horario.getHorario());
		stmt.setString(3, horario.getRoteiro());
		//stmt.setLong(4, horario.getId());
		stmt.execute();
		stmt.close();

	}

	public List<Horario> getLista() throws SQLException {

		List<Horario> contatos = new ArrayList<Horario>();

		String sql = "select * from horario";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Horario horario = new Horario();
			horario.setId(rs.getLong("id"));
			horario.setRoteiro(rs.getString("roteiro"));
			horario.setData(rs.getString("data"));
			horario.setHorario(rs.getString("horario"));
			contatos.add(horario);
		}
		rs.close();
		stmt.close();
		return contatos;

	}

}