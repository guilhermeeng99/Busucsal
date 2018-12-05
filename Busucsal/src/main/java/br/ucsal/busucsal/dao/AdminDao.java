package br.ucsal.busucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busucsal.model.Admin;
import br.ucsal.busucsal.utilis.ConnectionFactory;

public class AdminDao {

	private Connection connection;

	public AdminDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public Admin login(Admin admin) {
		Admin adminReturn = null;
		String sql = "select * from admin where login=? and senha=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, admin.getLogin());
			stmt.setString(2, admin.getSenha());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				adminReturn = new Admin();
				adminReturn.setId(rs.getInt("id"));
				adminReturn.setNome(rs.getString("nome"));
				adminReturn.setLogin(rs.getString("login"));
				adminReturn.setSenha(rs.getString("senha"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return adminReturn;

	}

	public void adiciona(Admin admin) {
		String sql = "insert into admin " + "(nome,login,senha)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getLogin());
			stmt.setString(3, admin.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from admin where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Admin admin) {
		String sql = "update admin set nome=? ,login=? ,senha=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getLogin());
			stmt.setString(3, admin.getSenha());
			stmt.setLong(4, admin.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Admin> getLista() {
		try {
			List<Admin> admins = new ArrayList<Admin>();
			String sql = "select * from admin";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Admin admin= new Admin();
				admin.setId(rs.getLong("id"));
				admin.setNome(rs.getString("nome"));
				admin.setLogin(rs.getString("login"));
				admin.setSenha(rs.getString("senha"));
				admins.add(admin);
			}
			rs.close();
			stmt.close();
			return admins;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Long getId(Admin admin,Admin antigo) {
		try {
			List<Admin> admins = new ArrayList<Admin>();
			String sql = "select * from admin where nome=? and login=? and senha=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, antigo.getNome());
			stmt.setString(2, antigo.getLogin());
			stmt.setString(3, antigo.getSenha());
			ResultSet rs = stmt.executeQuery();		
			Long val = 0l;
			while (rs.next()) {
				val = rs.getLong("id");
				admin.setId(rs.getLong("id"));
				admins.add(admin);
			}
			rs.close();
			stmt.close();
			return val;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Admin> getLista(Long id) {
		try {
			List<Admin> admins = new ArrayList<Admin>();
			String sql = "select * from admin where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getLong("id"));
				admin.setNome(rs.getString("nome"));
				admin.setLogin(rs.getString("login"));
				admin.setSenha(rs.getString("senha"));
				admins.add(admin);
			}
			rs.close();
			stmt.close();
			return admins;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Admin getAdmin(Long id) {
		String sql = "select * from admin where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getLong("id"));
				admin.setLogin(rs.getString("login"));
				admin.setNome(rs.getString("nome"));
				admin.setSenha(rs.getString("senha"));
				return admin;
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}