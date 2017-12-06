package br.com.poo.controleHospedagem.entity.Repository;

import br.com.poo.controleHospedagem.entity.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Hospedagens;
import br.com.poo.controleHospedagem.entity.ItemHospedagem;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemHospedagenRepository {

    private ConnectionRepository connection;

    private Connection conn;

    private PreparedStatement stmt;

    public ItemHospedagenRepository() {
        connection = new ConnectionRepository();
    }

    public void inserir(ItemHospedagem itemHospedagen) throws RepositoryException {
        try {
            int i = 0;
            conn = connection.getConnection();
            stmt = conn.prepareStatement("insert int item_hospedagens (itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp) values ( ? , ? , ? , ? , ? , ? )",
                     PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(++i, itemHospedagen.getProduto());
            stmt.setLong(++i, itemHospedagen.getQtd());
//            stmt.setBigDecimal(i++, itemHospedagen.getValorUnit());
            stmt.setLong(++i, itemHospedagen.getHospedagem().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            connection.releaseAll(stmt, conn);
        }
    }

    public List<ItemHospedagem> findByHopedagem(Long codigoHospedagem) throws RepositoryException {
            List<ItemHospedagem> listEntity = new ArrayList<>();
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("SELECT itemhosp_id, itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp FROM item_hospedagens WHERE itemhosp_idhosp = "+codigoHospedagem.toString());	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                                
                while (rs.next()) {                    
                    listEntity.add(new ItemHospedagem(
                            rs.getLong("itemhosp_id"), 
                            rs.getString("itemhosp_dsproduto"), 
                            rs.getInt("itemhosp_qtdproduto"), 
                            rs.getDouble("itemhosp_vldproduto"), 
                            rs.getInt("itemhosp_idhosp")));
                }
                
                connection.endTransaction();
              
                
            } catch (SQLException e) {
                throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
            } finally {
			connection.releaseAll(stmt, conn);
		}
            return listEntity; 

    }
    
        public List<ItemHospedagem> findAll() throws RepositoryException {
            List<ItemHospedagem> listEntity = new ArrayList<>();
            try {
                if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
		    connection.beginTransaction();
                }        
		
		this.conn = connection.getConnectionFromContext();
		
		stmt = conn.prepareStatement("SELECT itemhosp_id, itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp FROM item_hospedagens ");	
			
		
                
                ResultSet rs =  stmt.executeQuery();
                                
                while (rs.next()) {                    
                    listEntity.add(new ItemHospedagem(
                            rs.getLong("itemhosp_id"), 
                            rs.getString("itemhosp_dsproduto"), 
                            rs.getInt("itemhosp_qtdproduto"), 
                            rs.getDouble("itemhosp_vldproduto"), 
                            rs.getInt("itemhosp_idhosp")));
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
