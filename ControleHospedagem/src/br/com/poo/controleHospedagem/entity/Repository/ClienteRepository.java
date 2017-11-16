package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.sql.ResultSet;

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
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
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
        
        public Cliente findOne(Long codigo) throws RepositoryException{
            Cliente entity = null;
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		//TODO Altera INSERT
		stmt = conn.prepareStatement("select cli_id, cli_nome, cli_endereco, cli_uf, cli_telefone, cli_cpf, cli_email from cliente where cli_id = "+codigo.toString());	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                
                while (rs.next()) {                    
                    entity = new Cliente(rs.getLong("cli_id")
                            , rs.getString("cli_nome")
                            , rs.getString("cli_endereco")
                            , rs.getString("cli_uf")
                            , rs.getString("cli_telefone")
                            , rs.getString("cli_cpf")
                            , rs.getString("cli_email"));
                }
                
                connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			connection.releaseAll(stmt, conn);
		}
            return entity;        
        }

}
