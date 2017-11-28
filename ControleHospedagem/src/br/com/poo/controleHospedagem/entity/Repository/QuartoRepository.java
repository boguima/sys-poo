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
        
        private static final String INSERT = "insert into quartos_hospedagens (quahosp_ds,quahosp_st ,quahosp_vl ) values ( ? , ? , ? )";
        
        private static final String UPDATE = "update quartos_hospedagens  SET quahosp_ds = ?, quahosp_st = ?, quahosp_vl= ? where quahosp_id= ?";
	
	public QuartoRepository () {
		connection = new ConnectionRepository();		
	}

	public void inserir(Quarto quarto) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(quarto, INSERT, "insert", this.connection);
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

	public void inserir(Quarto quarto, String sql, String op,ConnectionRepository connection) throws SQLException {
		int i=0;
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement(sql
				, PreparedStatement.RETURN_GENERATED_KEYS);					
		stmt.setString(++i, quarto.getDescricao());
		stmt.setString(++i, quarto.getSituacao());
		stmt.setBigDecimal(++i, quarto.getValorDia());
		
		
                if ("update".equals(op)) {
                stmt.setLong(++i, quarto.getId());
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
                    , rs.getString("quahosp_st")
                    , rs.getBigDecimal("quahosp_vl"));
        }
        return entity;
    }
        
        public List<Quarto> findAll( )throws RepositoryException{
            List<Quarto> listEntity = new ArrayList<>();
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("select quahosp_id , quahosp_ds , quahosp_st , quahosp_vl from quartos_hospedagens ");	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                                
                while (rs.next()) {                    
                    listEntity.add(new Quarto(rs.getLong("quahosp_id")
                            ,rs.getString("quahosp_ds")
                            , rs.getString("quahosp_st")
                            , rs.getBigDecimal("quahosp_vl ")
                           
                           ));
                }
                
                connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			connection.releaseAll(stmt, conn);
		}
            return listEntity; 
        }
        
        
        	public void update(Quarto quarto) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(quarto, UPDATE, "update", this.connection);
			
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
		
		stmt = conn.prepareStatement("delete from quartos_hospedagens where quahosp_id = ?"
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
