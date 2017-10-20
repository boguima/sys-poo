package br.com.poo.controleHospedagem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

public class ConnectionRepository {

	//fornecer contexto transacional
	private static final ThreadLocal<Connection> context = new ThreadLocal<Connection>();

	private final String driverName = "com.mysql.jdbc.Driver";

	private final String url = "jdbc:mysql://localhost:3306/syshospede";

	private Connection con;

	private Statement stmt;

	/**
	 * Fornecer conex�o ao banco de dados
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(driverName);
			this.con = DriverManager.getConnection(url, "root", "");
			this.stmt = this.con.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO remover StackTrace
			e.printStackTrace();
		}
		return this.con;
	}
	
	/**
	 * Criar conex�o transacional. AutoCommit=FALSE
	 * @throws SQLException
	 */
	public void beginTransaction() throws SQLException {
		
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		context.set(conn);
		
	}
	
	/**
	 * Finaliza conex�o transacional.
	 * @throws SQLException
	 */
	public void endTransaction() throws SQLException {
		commit ( getConnectionFromContext() );
		releaseTransaction();
	}
	
	public void releaseTransaction() throws SQLException {
		Connection conn = getConnectionFromContext();
		relrase(conn);
		context.remove();
	}
	
	public void commit(Connection conn) throws SQLException{		
		conn.commit();
	}
	
	public Connection getConnectionFromContext() throws SQLException {
		Connection conn = context.get();
		if (conn == null) throw new SQLException("Transa��o invalida");		
		if (conn.isClosed()) throw new SQLException("Transa��o invalida, conex�o esta fechada :z");
		
		
		return context.get();		
	}

	public void release(Statement stmt) {
		if (stmt == null)
			return;

		try {
			stmt.close();
		} catch (SQLException e) {
		}

	}

	public void relrase(Connection conn) {
		if (conn == null)
			return;

		try {
			conn.close();
		} catch (SQLException e) {
		}

	}

	public void release(ResultSet rset) {
		if (rset == null)
			return;

		try {
			rset.close();
		} catch (SQLException e) {
		}

	}

	public void releaseAll(Statement stmt, Connection conn) {
		release(stmt);
		relrase(conn);
	}

	public void releaseAll(Statement stmt, Connection conn, ResultSet rset) {
		release(rset);
		releaseAll(stmt, conn);
	}
}
