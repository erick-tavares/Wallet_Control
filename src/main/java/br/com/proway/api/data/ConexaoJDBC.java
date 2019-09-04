package br.com.proway.api.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexaoJDBC {

	public Connection getConnection();

	public void close();

	public void commit() throws SQLException;

	public void rollback();

}
