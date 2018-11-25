package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.utilis.ConnectionFactory;

public class RoteiroDao {

	private Connection connection;

	public RoteiroDao(){
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Roteiro roteiro) {
		String sql = "insert into roteiro " + "(rota,saida,parada)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, roteiro.getRota());
			stmt.setString(2, roteiro.getSaida());
			stmt.setString(3, roteiro.getParada());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from roteiro where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Roteiro roteiro) {
		String sql = "update roteiro set rota=?, saida=? ,parada=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, roteiro.getRota());
			stmt.setString(2, roteiro.getSaida());
			stmt.setString(3, roteiro.getParada());
			stmt.setLong(4, roteiro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Roteiro> getLista(){

		try {
			List<Roteiro> roteiros = new ArrayList<Roteiro>();
			String sql = "select * from roteiro";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Roteiro roteiro = new Roteiro();
				roteiro.setId(rs.getLong("id"));
				roteiro.setRota(rs.getString("rota"));
				roteiro.setSaida(rs.getString("saida"));
				roteiro.setParada(rs.getString("parada"));
				roteiros.add(roteiro);
			}
			rs.close();
			stmt.close();
			return roteiros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Roteiro getRoteiro(Long id) {
		String sql = "select * from roteiro where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Roteiro roteiro = new Roteiro();
				roteiro.setId(rs.getLong("id"));
				roteiro.setRota(rs.getString("rota"));
				roteiro.setSaida(rs.getString("saida"));
				roteiro.setParada(rs.getString("parada"));
				return roteiro;
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}