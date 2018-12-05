package br.ucsal.busucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busucsal.model.Horario;
import br.ucsal.busucsal.utilis.ConnectionFactory;

public class HorarioDao {

	private Connection connection;

	public HorarioDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Horario horario) {
		String sql = "insert into horario " + "(horario,data,roteiro)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, horario.getHorario());
			stmt.setString(2, horario.getData());
			stmt.setString(3, horario.getRoteiro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from horario where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Horario horario) {
		String sql = "update horario set horario=?, data=? ,roteiro=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, horario.getHorario());
			stmt.setString(2, horario.getData());
			stmt.setString(3, horario.getRoteiro());
			stmt.setLong(4, horario.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Horario> getLista() {
		try {
			List<Horario> horarios = new ArrayList<Horario>();
			String sql = "select * from horario";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Horario Horario = new Horario();
				Horario.setId(rs.getLong("id"));
				Horario.setHorario(rs.getString("horario"));
				Horario.setData(rs.getString("data"));
				Horario.setRoteiro(rs.getString("roteiro"));
				horarios.add(Horario);
			}
			rs.close();
			stmt.close();
			return horarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Horario getHorario(Long id) {
		String sql = "select * from horario where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Horario horario = new Horario();
				horario.setId(rs.getLong("id"));
				horario.setHorario(rs.getString("horario"));
				horario.setData(rs.getString("data"));
				horario.setRoteiro(rs.getString("roteiro"));
				return horario;
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}