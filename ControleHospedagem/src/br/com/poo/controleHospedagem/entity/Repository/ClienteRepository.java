package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;

public class ClienteRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
	
	public ClienteRepository () {
		connection = new ConnectionRepository();		
	}

	public void inserir(Cliente cliente) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(cliente, this.connection);
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("Não foi possivel realizar a transação", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

	public void inserir(Cliente cliente, ConnectionRepository connection) throws SQLException {
		int i=0;
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("insert into cliente (cli_nome, cli_endereco, cli_uf, cli_telefone, cli_cpf, cli_email) values ( ? , ? , ? , ? , ? , ? )"
				, PreparedStatement.RETURN_GENERATED_KEYS);					
		stmt.setString(++i, cliente.getNomeCliente());
		stmt.setString(++i, cliente.getEndereco());
		stmt.setString(++i, cliente.getUf());
		stmt.setString(++i, cliente.getTelefone());
		stmt.setString(++i, cliente.getCpf() );
		stmt.setString(++i, cliente.getEMail());			
		stmt.executeUpdate();
	}

}
