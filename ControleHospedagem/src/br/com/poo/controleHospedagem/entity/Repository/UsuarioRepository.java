package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.sql.ResultSet;

public class UsuarioRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
	
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
		stmt = conn.prepareStatement("insert into cliente (cli_nome, cli_endereco, cli_uf, cli_telefone, cli_cpf, cli_email) values ( ? , ? , ? , ? , ? , ? )"
				, PreparedStatement.RETURN_GENERATED_KEYS);					
		stmt.setString(++i, usuario.getUsuario());
                stmt.setString(++i, usuario.getSenha());
			
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
		stmt = conn.prepareStatement("select usu_id, usu_usuario, usu_senha from usuario where usu_usuario = '"+usuario+"'");	
			
		
                
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

}
