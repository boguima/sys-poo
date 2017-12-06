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
import java.util.ArrayList;
import java.util.List;

public class HospedagensRepository {

    private ConnectionRepository connection;

    private Connection conn;

    private PreparedStatement stmt;

    public HospedagensRepository() {
        connection = new ConnectionRepository();
    }

    private static final String UPDATEQUARTO = "update quartos_hospedagens  SET quahosp_ds = ?, quahosp_st = ?, quahosp_vl= ? where quahosp_id= ?";

    public void inserir(Hospedagens hospedagen) throws RepositoryException {
        try {
            int i = 0;
            if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
                connection.beginTransaction();
            }
            conn = connection.getConnection();
            stmt = conn.prepareStatement("INSERT INTO hospedagens (hosp_dtentrada, hosp_dtsaida, hosp_stcheckout, hosp_idcliente, hosp_observacao, hosp_idquarto) VALUES (?, ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(++i, hospedagen.getDataEntradaAux());
            stmt.setString(++i, hospedagen.getDataSaidaAux().equals("") ? null : hospedagen.getDataSaidaAux());
            stmt.setString(++i, hospedagen.getStCheckout());
            stmt.setLong(++i, hospedagen.getCliente().getId());
            stmt.setString(++i, hospedagen.getObservacao());
            stmt.setLong(++i, hospedagen.getQuarto().getId());
            stmt.executeUpdate();
            connection.endTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
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
                        new Quarto(rs.getLong("hosp_idquarto")),
                        "",
                        ""
                );
            }
            if (entity != null && entity.getCliente() != null) {
                entity.setCliente((new ClienteRepository()).reflectionFindOne(entity.getCliente().getId(), entity.getCliente(), this.connection));

            }
            if (entity != null && entity.getQuarto() != null) {
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

    public void update(Hospedagens hospedagem) throws RepositoryException {
        try {
            if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
                connection.beginTransaction();
            }

            int i = 0;

            this.conn = connection.getConnectionFromContext();

            stmt = conn.prepareStatement("UPDATE hospedagens SET hosp_dtentrada = ?, hosp_dtsaida = ?, hosp_stcheckout = ?, hosp_idcliente = ?, hosp_observacao = ?, hosp_idquarto = ? WHERE hosp_id = ?",
                    PreparedStatement.NO_GENERATED_KEYS);
            stmt.setString(++i, hospedagem.getDataEntradaAux());
            stmt.setString(++i, hospedagem.getDataSaidaAux().equals("") ? null : hospedagem.getDataSaidaAux());
            stmt.setString(++i, hospedagem.getStCheckout());
            stmt.setLong(++i, hospedagem.getCliente().getId());
            stmt.setString(++i, hospedagem.getObservacao());
            stmt.setLong(++i, hospedagem.getQuarto().getId());
            stmt.setLong(++i, hospedagem.getId());
            stmt.executeUpdate();

            connection.endTransaction();
        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            connection.releaseAll(stmt, conn);
        }
    }

    public void delete(Hospedagens entity) throws RepositoryException {
        try {
            if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
                connection.beginTransaction();
            }

            int i = 0;

            this.conn = connection.getConnectionFromContext();

            stmt = conn.prepareStatement("delete from hospedagens where hosp_id = ?",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setLong(++i, entity.getId());

            if (entity.getQuarto() != null) {
                entity.getQuarto().setSituacao("0");
                (new QuartoRepository()).inserir(entity.getQuarto(), UPDATEQUARTO, "update", this.connection);
            }

            stmt.executeUpdate();

            connection.endTransaction();
        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            connection.releaseAll(stmt, conn);
        }
    }

    public List<Hospedagens> findAll() throws RepositoryException {
        List<Hospedagens> entityList = new ArrayList<>();
        Hospedagens entity = null;
        try {
            if (this.connection.getConnectionContext() == null || this.connection.getConnectionContext().isClosed()) {
                this.connection.beginTransaction();
            }

            this.conn = this.connection.getConnectionFromContext();

            stmt = conn.prepareStatement("select hosp_id, hosp_dtentrada, hosp_dtsaida, hosp_stcheckout, hosp_idcliente, hosp_observacao, hosp_idquarto from hospedagens");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                entity = new Hospedagens(rs.getInt("hosp_id"),
                        rs.getDate("hosp_dtentrada"),
                        rs.getDate("hosp_dtsaida"),
                        new Cliente(rs.getLong("hosp_idcliente")),
                        rs.getString("hosp_stcheckout"),
                        rs.getString("hosp_observacao"),
                        new Quarto(rs.getLong("hosp_idquarto")),
                        "",
                        ""
                );

                if (entity != null && entity.getCliente() != null) {
                    entity.setCliente((new ClienteRepository()).reflectionFindOne(entity.getCliente().getId(), entity.getCliente(), this.connection));

                }
                if (entity != null && entity.getQuarto() != null) {
                    entity.setQuarto((new QuartoRepository()).reflectionFindOne(entity.getQuarto().getId(), entity.getQuarto(), this.connection));

                }
                entityList.add(entity);
                
            }

            this.connection.endTransaction();

        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            this.connection.releaseAll(stmt, conn);
        }
        return entityList;
    }

}
