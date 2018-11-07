package br.ucsal.cliente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.cliente.model.Rota;

public class RotaDao {

	private Connection connection;

	public RotaDao() throws SQLException, ClassNotFoundException {
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Rota rota) {
		String sql = "insert into rota " + "(roteiro,saida,paradas)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, rota.getRoteiro());
			stmt.setString(2, rota.getSaida());
			stmt.setString(3, rota.getParadas());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Rota rota) throws SQLException {

		String sql = "delete from rota where roteiro=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, rota.getRoteiro());
		stmt.execute();
		stmt.close();

	}

	public void altera(Rota rota) throws SQLException {
		String sql = "update rota set saida=?, paradas=? where roteiro=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, rota.getSaida());
		stmt.setString(2, rota.getParadas());
		stmt.setString(3, rota.getRoteiro());
		//stmt.setLong(4, rota.getId());
		stmt.execute();
		stmt.close();

	}

	public List<Rota> getLista() throws SQLException {

		List<Rota> contatos = new ArrayList<Rota>();

		String sql = "select * from rota";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Rota rota = new Rota();
			rota.setId(rs.getLong("id"));
			rota.setRoteiro(rs.getString("roteiro"));
			rota.setSaida(rs.getString("saida"));
			rota.setParadas(rs.getString("paradas"));
			contatos.add(rota);
		}
		rs.close();
		stmt.close();
		return contatos;

	}

}