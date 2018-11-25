package br.ucsal.utilis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;

	private static Connection connection = null;

	private String conStr = "jdbc:hsqldb:hsql://localhost/busucsal";
	private String usuario = "sa";
	private String senha = "";

	private ConnectionFactory() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection(conStr, usuario, senha);
			connection.createStatement()
					.execute("CREATE TABLE IF NOT EXISTS ROTEIRO  ( " + "  ID BIGINT IDENTITY PRIMARY KEY,"
							+ "  ROTA VARCHAR(255), SAIDA VARCHAR(255), PARADA VARCHAR(255) "
							+ ");");
			connection.createStatement()
					.execute("CREATE TABLE IF NOT EXISTS HORARIO  ( " + "  ID BIGINT IDENTITY PRIMARY KEY,"
							+ "  HORARIO VARCHAR(255), DATA VARCHAR(255), ROTEIRO VARCHAR(255) "
							+ ");");
			connection.createStatement()
			.execute("CREATE TABLE IF NOT EXISTS ADMIN  ( " + "  ID BIGINT IDENTITY PRIMARY KEY,"
					+ "  NOME VARCHAR(255), LOGIN VARCHAR(255), SENHA VARCHAR(255) "
					+ ");");
 		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
 	}

	public static Connection getConnection() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connection;
	}

}