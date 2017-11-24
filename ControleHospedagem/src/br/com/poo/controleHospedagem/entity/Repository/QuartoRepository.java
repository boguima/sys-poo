package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Quarto;
import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
        
        private static final String INSERT = "insert into cliente (cli_nome, cli_endereco, cli_uf, cli_telefone, cli_cpf, cli_email) values ( ? , ? , ? , ? , ? , ? )";
        
        private static final String UPDATE = "update cliente SET cli_nome = ?, cli_endereco = ?, cli_uf = ?, cli_telefone = ?, cli_cpf = ?, cli_email = ? where cli_id = ?";
	
	public QuartoRepository () {
		connection = new ConnectionRepository();		
	}

	public void inserir(Cliente cliente) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(cliente, INSERT, "insert", this.connection);
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

	public void inserir(Cliente cliente, String sql, String op,ConnectionRepository connection) throws SQLException {
		int i=0;
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement(sql
				, PreparedStatement.RETURN_GENERATED_KEYS);					
		stmt.setString(++i, cliente.getNomeCliente());
		stmt.setString(++i, cliente.getEndereco());
		stmt.setString(++i, cliente.getUf());
		stmt.setString(++i, cliente.getTelefone());
		stmt.setString(++i, cliente.getCpf() );
		stmt.setString(++i, cliente.getEMail());
                if ("update".equals(op)) {
                stmt.setLong(++i, cliente.getId());
            }
		stmt.executeUpdate();
	}
        
        public Quarto findOne(Long codigo) throws RepositoryException{
            Quarto entity = null;
            try {
                if (this.connection.getConnectionContext() == null || this.connection.getConnectionContext().isClosed()) {
		    this.connection.beginTransaction();
                }        
		
		entity = reflectionFindOne(codigo, entity, this.connection);
                
                this.connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			this.connection.releaseAll(stmt, conn);
		}
            return entity;        
        }

    public Quarto reflectionFindOne(Long codigo, Quarto entity, ConnectionRepository connection) throws SQLException {
        this.conn = connection.getConnectionFromContext();
        stmt = this.conn.prepareStatement("select quahosp_id, quahosp_ds, quahosp_st, quahosp_vl from quartos_hospedagens where quahosp_id = "+codigo.toString());
        ResultSet rs =  stmt.executeQuery();
        while (rs.next()) {
            entity = new Quarto(rs.getLong("quahosp_id")
                    , rs.getString("quahosp_ds")
                    , rs.getString("quahosp_st").charAt(0)
                    , rs.getBigDecimal("quahosp_vl"));
        }
        return entity;
    }
        
        public List<Cliente> findAll( )throws RepositoryException{
            List<Cliente> listEntity = new ArrayList<>();
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("select cli_id, cli_nome, cli_endereco, cli_uf, cli_telefone, cli_cpf, cli_email from cliente");	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                                
                while (rs.next()) {                    
                    listEntity.add(new Cliente(rs.getLong("cli_id")
                            , rs.getString("cli_nome")
                            , rs.getString("cli_endereco")
                            , rs.getString("cli_uf")
                            , rs.getString("cli_telefone")
                            , rs.getString("cli_cpf")
                            , rs.getString("cli_email")));
                }
                
                connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			connection.releaseAll(stmt, conn);
		}
            return listEntity; 
        }
        
        
        	public void update(Cliente cliente) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(cliente, UPDATE, "update", this.connection);
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}
        public void delete(Long id) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
                int i=0;
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("delete from cliente where cli_id = ?"
				, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setLong(++i, id);
            
		stmt.executeUpdate();
			
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}        

}
