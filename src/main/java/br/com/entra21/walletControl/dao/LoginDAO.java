package br.com.entra21.walletControl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.entra21.walletControl.data.ConexaoJDBC;
import br.com.entra21.walletControl.data.ConexaoMysqlJDBC;
import br.com.entra21.walletControl.model.Usuario;

public class LoginDAO {

	private final ConexaoJDBC conexao;
	private String sqlQuery;
	private PreparedStatement stmt;

	public LoginDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Usuario autenticarLogin(Usuario usuario) throws SQLException, ClassNotFoundException {
		sqlQuery = "SELECT 	* FROM 	usuario WHERE EMAIL = ? AND SENHA = ?;";
		try {
			stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}

		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return null;
	}
	
	
	private Usuario parser(ResultSet resultSet) throws SQLException {
		Usuario u = new Usuario();

		u.setId(resultSet.getLong("ID"));
		u.setNome(resultSet.getString("NOME"));
		u.setEmail(resultSet.getString("EMAIL"));
		u.setSenha(resultSet.getString("SENHA"));

		return u;
	}

}
