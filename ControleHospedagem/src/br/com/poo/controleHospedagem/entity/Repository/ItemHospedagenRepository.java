package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Hospedagens;
import br.com.poo.controleHospedagem.entity.ItemHospedagem;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;

public class ItemHospedagenRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
	
	public ItemHospedagenRepository () {
		connection = new ConnectionRepository();		
	}

	public void inserir(ItemHospedagem itemHospedagen) throws RepositoryException {
		try {
			int i=0;
			conn = connection.getConnection();
			stmt = conn.prepareStatement("insert int item_hospedagens (itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp) values ( ? , ? , ? , ? , ? , ? )"
					, PreparedStatement.RETURN_GENERATED_KEYS);					
			stmt.setString(++i, itemHospedagen.getProduto());
			stmt.setLong(++i, itemHospedagen.getQtd());
			stmt.setBigDecimal(i++, itemHospedagen.getValorUnit());
			stmt.setLong(++i, itemHospedagen.getHospedagem().getIdhosp());						
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RepositoryException("Não foi possivel realizar a transação", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

}
