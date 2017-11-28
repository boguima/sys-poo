package br.com.poo.controleHospedagem.entity.Repository;

import br.com.poo.controleHospedagem.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
        
        private static final String FINDONE = "select usu_id, usu_usuario, usu_senha from usuario where usu_usuario = '";
	private static final String UPDATE = "update usuario SET  usu_usuario = ?, usu_senha = ?  where usu_id = ?";
	public UsuarioRepository () {
		connection = new ConnectionRepository();		
	}

	public void inserir(Usuario usuario) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(usuario, this.connection);
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

	public void inserir(Usuario usuario, ConnectionRepository connection) throws SQLException {
		int i=0;
		
		this.conn = connection.getConnectionFromContext();
		//TODO Altera INSERT
		stmt = conn.prepareStatement("insert into usuario (usu_usuario, usu_senha) values ( ? , ? )"
				, PreparedStatement.RETURN_GENERATED_KEYS);					
		stmt.setString(++i, usuario.getUsuario());
                stmt.setString(++i, usuario.getSenha());
			
		stmt.executeUpdate();
	}
        
        public void inserir(Usuario usuario, String sql, String op,ConnectionRepository connection) throws SQLException {
		int i=0;
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement(sql
				, PreparedStatement.RETURN_GENERATED_KEYS);					
		stmt.setString(++i, usuario.getUsuario());
		stmt.setString(++i, usuario.getSenha());
		
                if ("update".equals(op)) {
                stmt.setLong(++i, usuario.getId());
            }
		stmt.executeUpdate();
	}
        
        
        
        public Usuario findOne(String usuario) throws RepositoryException {
            Usuario entity = null;
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		//TODO Altera INSERT
		stmt = conn.prepareStatement(FINDONE+usuario+"'");	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                
                while (rs.next()) {                    
                    entity = new Usuario(Long.parseLong(rs.getString("usu_id")), rs.getString("usu_usuario"), rs.getString("usu_senha"));
                }
                
                connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			connection.releaseAll(stmt, conn);
		}
            return entity;
        }
        
        
           public void delete(Long id) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
                int i=0;
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("delete from usuario where usu_id = ?"
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
           
           
           public void update(Usuario usuario) throws RepositoryException {
		try {
			if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
				connection.beginTransaction();
			}			
			
			inserir(usuario, UPDATE, "update", this.connection);
			
			connection.endTransaction();			
		} catch (SQLException e) {
			throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}
           
           
           public List<Usuario> findAll( )throws RepositoryException{
            List<Usuario> listEntity = new ArrayList<>();
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("select usu_id, usu_usuario, usu_senha  from usuario");	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                                
                while (rs.next()) {                    
                    listEntity.add(new Usuario(rs.getLong("usu_id")
                            , rs.getString("usu_usuario")
                            , rs.getString("usu_senha")));
                            
                }
                
                connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			connection.releaseAll(stmt, conn);
		}
            return listEntity; 
        }
        

}
