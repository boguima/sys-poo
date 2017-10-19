package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.Util.Repository.ConnectionRepository;
import br.com.poo.Util.Repository.RepositoryException;
import br.com.poo.controleHospedagem.entity.Cliente;

public class ClienteRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
	
	public ClienteRepository () {
		connection = new ConnectionRepository();
		
	}

	public void inserir(Cliente cliente) throws RepositoryException {
		try {
			int i=0;
			conn = connection.getConnection();
			stmt = conn.prepareStatement("insert int cliente (cli_nome, cli_endereco, cli_uf, cli_telefone, cli_cpf, cli_email) values ( ? , ? , ? , ? , ? , ? )");		
			stmt.setString(++i, cliente.getNomeCliente());
			stmt.setString(++i, cliente.getEndereco());
			stmt.setString(++i, cliente.getUf());
			stmt.setString(++i, cliente.getTelefone());
			stmt.setString(++i, cliente.getCpf() );
			stmt.setString(++i, cliente.getEMail());			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RepositoryException("Não foi possivel realizar a transação", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

}
