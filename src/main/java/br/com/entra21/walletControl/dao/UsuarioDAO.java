package br.com.entra21.walletControl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entra21.walletControl.data.ConexaoJDBC;
import br.com.entra21.walletControl.data.ConexaoMysqlJDBC;
import br.com.entra21.walletControl.model.Usuario;

public class UsuarioDAO {

	private final ConexaoJDBC conexao;

	public UsuarioDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Usuario usuario) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO usuario (EMAIL, SENHA, NOME) VALUES (?, ?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Usuario usuario) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE usuario SET EMAIL = ?, NOME = ?, SENHA = ? WHERE ID = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(4, usuario.getId());

			linhasAfetadas = stmt.executeUpdate();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(long id) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM usuario WHERE ID = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Usuario selecionar(long id) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM usuario WHERE ID = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Usuario> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM usuario ORDER BY ID";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Usuario> usuarios = new ArrayList<>();

			while (rs.next()) {
				usuarios.add(parser(rs));
			}

			return usuarios;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Usuario parser(ResultSet resultSet) throws SQLException {
		Usuario c = new Usuario();

		c.setId(resultSet.getLong("ID"));
		c.setEmail(resultSet.getString("EMAIL"));
		c.setSenha(resultSet.getString("SENHA"));
		c.setNome(resultSet.getString("NOME"));

		return c;
	}
}
