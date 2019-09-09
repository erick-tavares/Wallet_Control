package br.com.proway.api.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.proway.api.data.ConexaoJDBC;
import br.com.proway.api.data.ConexaoMysqlJDBC;
import br.com.proway.api.model.Despesa;
import br.com.proway.api.model.util.Status;


public class DespesaDAO {

	private final ConexaoJDBC conexao;

	public DespesaDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Despesa despesa) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO despesa (DESCRICAO_DESPESA, CATEGORIA, DATA_VENC, VALOR_DESPESA, PRIORIDADE, STATUS, PARCELA, ID_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, despesa.getDescDespesa());
			stmt.setString(2, despesa.getCatDespesa());
			stmt.setString(3, despesa.getDtVenc().toString());
			stmt.setString(4, despesa.getValorDespesa() + "");
			stmt.setString(5, despesa.getPrioridade());
			stmt.setString(6, despesa.getStatus().toString());
			stmt.setString(7, despesa.getParcela() + "");
			stmt.setString(8, despesa.getIdUsuario() + "");
			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Despesa despesa) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE despesa SET DESCRICAO_DESPESA = ?, CATEGORIA = ?, DATA_VENC = ?, VALOR_DESPESA = ?, PRIORIDADE = ?, STATUS = ?, PARCELA = ?,   WHERE id = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, despesa.getAssunto());
			stmt.setString(2, despesa.getStatus().toString());
			stmt.setString(3, despesa.getMensagem());
			stmt.setLong(4, despesa.getId());

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
		String sqlQuery = "DELETE FROM despesa WHERE id = ?";

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

	public Despesa selecionar(long id) throws SQLException, ClassNotFoundException {
		StringBuilder sqlQuery = new StringBuilder("SELECT * FROM despesa");
		
		

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
			
			
			if(restricao de tela) {
				sqlQuery.append("WHERE id = ?");
			}
			
			sqlQuery.append(" order by 1");
		} catch (SQLException e) {
			throw e;
		}

		return sqlQuery;
	}

	public List<Despesa> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM despesa ORDER BY id";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Despesa> despesas = new ArrayList<>();

			while (rs.next()) {
				despesas.add(parser(rs));
			}

			return despesas;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Despesa parser(ResultSet resultSet) throws SQLException {
		Despesa d = new Despesa();

		d.setId(resultSet.getLong("id"));
		d.setAssunto(resultSet.getString("assunto"));
		d.setMensagem(resultSet.getString("mensagem"));
		d.setStatus(Status.valueOf(resultSet.getString("status")));

		return d;
	}
}
