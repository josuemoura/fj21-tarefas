package br.com.caelum.tarefa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnectionMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21", "root", "brasil");
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new RuntimeException(exc);
		}
	}
	public Connection getConnectionPostgreSQL() {
		try {
			Class.forName("org.postgresql.Driver");
			DriverManager.registerDriver(new org.postgresql.Driver());
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost/fj21", "postgres", "brasil");
		} catch (SQLException exc) {
			throw new RuntimeException(exc);

		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new RuntimeException(exc);
		}
	}
}
