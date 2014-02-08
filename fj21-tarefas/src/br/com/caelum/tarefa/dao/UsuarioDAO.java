package br.com.caelum.tarefa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefa.modelo.Usuario;

@Repository
public class UsuarioDAO {

	Connection connection;

	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		String sql = "select * from usuarios where login = ?  and senha = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = null;
			stmt.setString(1, usuario.getlogin());
			stmt.setString(2, usuario.getSenha());
			stmt.executeQuery();
			rs = stmt.getResultSet();
			
			// verifica se existe retorno na consulta
			if (rs.next()) {
				stmt.close();
				return true;
			} else {
				stmt.close();
				return false;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
