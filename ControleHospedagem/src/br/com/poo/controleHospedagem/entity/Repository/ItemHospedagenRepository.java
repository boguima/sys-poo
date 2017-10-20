package br.com.poo.controleHospedagem.entity.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Hospedagens;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;

public class ItemHospedagenRepository {

	private ConnectionRepository connection;
	
	private Connection conn;
	
	private PreparedStatement stmt;
	
	public ItemHospedagenRepository () {
		connection = new ConnectionRepository();		
	}

	public void inserir(Hospedagens hospedagen) throws RepositoryException {
		try {
			int i=0;
			conn = connection.getConnection();
			stmt = conn.prepareStatement("insert int hospedagens (hosp_nmquarto, hosp_dtentrada, hosp_dtsaida, hosp_stcheckout, hosp_idcliente, hosp_observacao) values ( ? , ? , ? , ? , ? , ? )"
					, PreparedStatement.RETURN_GENERATED_KEYS);					
			stmt.setInt(++i, hospedagen.getNumQuarto());
			stmt.setDate(++i, (Date) hospedagen.getDataEntrada());
			stmt.setDate(++i, (Date) hospedagen.getDataSaida());
			stmt.setString(++i, hospedagen.getStCheckout());
			stmt.setLong(++i, hospedagen.getCliente().getId());
			stmt.setString(++i, hospedagen.getObservacao());			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RepositoryException("Não foi possivel realizar a transação", e);
		} finally {
			connection.releaseAll(stmt, conn);
		}
	}

}
