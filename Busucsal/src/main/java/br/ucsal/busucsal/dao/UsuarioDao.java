package br.ucsal.busucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busucsal.model.Usuario;
import br.ucsal.busucsal.utilis.ConnectionFactory;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public Usuario login(Usuario usuario) {
		Usuario usuarioReturn = null;
		String sql = "select * from usuario where login=? and senha=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuarioReturn = new Usuario();
				usuarioReturn.setId(rs.getInt("id"));
				usuarioReturn.setNome(rs.getString("nome"));
				usuarioReturn.setLogin(rs.getString("login"));
				usuarioReturn.setSenha(rs.getString("senha"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return usuarioReturn;

	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario " + "(nome,login,senha)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from usuario where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Usuario usuario) {
		String sql = "update usuario set nome=? ,login=? ,senha=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(4, usuario.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario= new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Long getId(Usuario usuario,Usuario antigo) {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario where nome=? and login=? and senha=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, antigo.getNome());
			stmt.setString(2, antigo.getLogin());
			stmt.setString(3, antigo.getSenha());
			ResultSet rs = stmt.executeQuery();		
			Long val = 0l;
			while (rs.next()) {
				val = rs.getLong("id");
				usuario.setId(rs.getLong("id"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return val;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getLista(Long id) {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario getUsuario(Long id) {
		String sql = "select * from usuario where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}