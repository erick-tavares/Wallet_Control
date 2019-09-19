package br.com.entra21.walletControl.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMysqlJDBC implements ConexaoJDBC {

	private Connection connection = null;

	private static final String USERNAME = "root";

	private static final String PASSWORD = "";

<<<<<<< HEAD:src/main/java/br/com/entra21/walletControl/data/ConexaoMysqlJDBC.java
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3308/wallet_control?useTimezone=true&serverTimezone=UTC";
=======
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/wallet_control?useTimezone=true&serverTimezone=UTC";
>>>>>>> 03d1ef9002ac905b5abda138b15d10655299fdf9:src/main/java/br/com/proway/api/data/ConexaoMysqlJDBC.java

	public ConexaoMysqlJDBC() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); 
		this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		this.connection.setAutoCommit(false);		
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

	@Override
	public void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoMysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void commit() throws SQLException {
		this.connection.commit();
		this.close();
	}

	@Override
	public void rollback() {
		if (this.connection != null) {
			try {
				this.connection.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoMysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				this.close();
			}
		}
	}

}
