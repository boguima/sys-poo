package br.com.poo.controleHospedagem.entity.Repository;

import br.com.poo.controleHospedagem.entity.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.poo.controleHospedagem.entity.Hospedagens;
import br.com.poo.controleHospedagem.entity.Quarto;
import br.com.poo.controleHospedagem.util.ConnectionRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.sql.ResultSet;

public class HospedagensRepository {

    private ConnectionRepository connection;

    private Connection conn;

    private PreparedStatement stmt;

    public HospedagensRepository() {
        connection = new ConnectionRepository();
    }

    public void inserir(Hospedagens hospedagen) throws RepositoryException {
        try {
            int i = 0;
            conn = connection.getConnection();
            stmt = conn.prepareStatement("insert int hospedagens (hosp_dtentrada, hosp_dtsaida, hosp_stcheckout, hosp_idcliente, hosp_observacao) values ( ? , ? , ? , ? , ? )",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setDate(++i, (Date) hospedagen.getDataEntrada());
            stmt.setDate(++i, (Date) hospedagen.getDataSaida());
            stmt.setString(++i, hospedagen.getStCheckout());
            stmt.setLong(++i, hospedagen.getCliente().getId());
            stmt.setString(++i, hospedagen.getObservacao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            connection.releaseAll(stmt, conn);
        }
    }

    public Hospedagens findOne(Long codigo) throws RepositoryException {
        Hospedagens entity = null;
        try {
            if (this.connection.getConnectionContext() == null || this.connection.getConnectionContext().isClosed()) {
                this.connection.beginTransaction();
            }

            this.conn = this.connection.getConnectionFromContext();

            stmt = conn.prepareStatement("select hosp_id, hosp_dtentrada, hosp_dtsaida, hosp_stcheckout, hosp_idcliente, hosp_observacao, hosp_idquarto from hospedagens where hosp_id = " + codigo.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                entity = new Hospedagens(rs.getInt("hosp_id"),
                         rs.getDate("hosp_dtentrada"),
                         rs.getDate("hosp_dtsaida"),
                         new Cliente(rs.getLong("hosp_idcliente")),
                         rs.getString("hosp_stcheckout"),
                         rs.getString("hosp_observacao"),
                         new Quarto(rs.getLong("hosp_idquarto"))
                );
            }
            if (entity != null && entity.getCliente() != null) {
                entity.setCliente((new ClienteRepository()).reflectionFindOne(entity.getCliente().getId(), entity.getCliente(), this.connection));

            }
            if (entity != null &&  entity.getQuarto() != null) {
                entity.setQuarto((new QuartoRepository()).reflectionFindOne(entity.getQuarto().getId(), entity.getQuarto(), this.connection));

            }

            this.connection.endTransaction();

        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            this.connection.releaseAll(stmt, conn);
        }
        return entity;
    }

}
