package br.com.proway.api.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.proway.api.data.ConexaoJDBC;
import br.com.proway.api.data.ConexaoMysqlJDBC;
import br.com.proway.api.model.Renda;


public class RendaDAO {

	private final ConexaoJDBC conexao;

	public RendaDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Renda renda) throws SQLException, ClassNotFoundException {
		Long ID = null;
		String sqlQuery = "INSERT INTO chamado (DESCRICAO_RENDA, VALOR_RENDA) VALUES (?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, renda.getDESCRICAO_RENDA());
			stmt.setString(2, renda.getVALOR_RENDA().toString());
			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return ID;
	}

	public int alterar(Renda renda) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE renda SET DESCRICAO_RENDA = ?, VALOR_RENDA = ? WHERE ID = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, renda.getDESCRICAO_RENDA());
			stmt.setString(2, renda.getVALOR_RENDA().toString());
			stmt.setLong(4, renda.getId());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(long ID) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM renda WHERE ID = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, ID);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Renda selecionar(long ID) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM renda WHERE ID = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, ID);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Renda> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM renda ORDER BY ID";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Renda> renda = new ArrayList<>();

			while (rs.next()) {
				renda.add(parser(rs));
			}

			return renda;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Renda parser(ResultSet resultSet) throws SQLException {
		Renda c = new Renda();

		c.setId(resultSet.getLong("ID"));
		c.setDESCRICAO_RENDA(resultSet.getString("descricao_renda"));
		c.setVALOR_RENDA(resultSet.getString("valor_renda"));
		
		return c;
	}
}
