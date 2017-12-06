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

    private static final String INSERT = "insert into item_hospedagens (itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp) values ( ? , ? , ? , ? )";

    private static final String UPDATE = "update item_hospedagens SET itemhosp_dsproduto = ?, itemhosp_qtdproduto = ?, itemhosp_vldproduto = ?, itemhosp_idhosp = ? where itemhosp_id = ?";

    public ItemHospedagenRepository() {
        connection = new ConnectionRepository();
    }

    public void inserir(ItemHospedagem itemHospedagen) throws RepositoryException {
        try {
            int i = 0;
            if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
                connection.beginTransaction();
            }
            
            inserir(itemHospedagen, INSERT, "insert", this.connection);

            connection.endTransaction();
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

            stmt = conn.prepareStatement("SELECT itemhosp_id, itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp FROM item_hospedagens WHERE itemhosp_idhosp = " + codigoHospedagem.toString());

            ResultSet rs = stmt.executeQuery();

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

            ResultSet rs = stmt.executeQuery();

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

    public ItemHospedagem findOne(Long codigo) throws RepositoryException {
        ItemHospedagem entity = null;
        try {
            if (this.connection.getConnectionContext() == null || this.connection.getConnectionContext().isClosed()) {
                this.connection.beginTransaction();
            }

            this.conn = this.connection.getConnectionFromContext();

            stmt = conn.prepareStatement("SELECT itemhosp_id, itemhosp_dsproduto, itemhosp_qtdproduto, itemhosp_vldproduto, itemhosp_idhosp FROM item_hospedagens where itemhosp_id = " + codigo.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                entity = new ItemHospedagem(rs.getLong("itemhosp_id"),
                        rs.getString("itemhosp_dsproduto"),
                        rs.getInt("itemhosp_qtdproduto"),
                        rs.getDouble("itemhosp_vldproduto"),
                        new Hospedagens(rs.getInt("itemhosp_idhosp")));
            }

            this.connection.endTransaction();

        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            this.connection.releaseAll(stmt, conn);
        }
        return entity;
    }

    public void update(ItemHospedagem itemHospedagem) throws RepositoryException {
        try {
            if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
                connection.beginTransaction();
            }

            inserir(itemHospedagem, UPDATE, "update", this.connection);

            connection.endTransaction();
        } catch (SQLException e) {
            throw new RepositoryException("N�o foi possivel realizar a transa��o", e);
        } finally {
            connection.releaseAll(stmt, conn);
        }
    }

    public void inserir(ItemHospedagem itemHospedagem, String sql, String op, ConnectionRepository connection) throws SQLException {
        int i = 0;

        this.conn = connection.getConnectionFromContext();

        stmt = conn.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, itemHospedagem.getProduto());
            stmt.setLong(2,   itemHospedagem.getQtd());
            stmt.setDouble(3, itemHospedagem.getValorUnit());
            stmt.setLong(4,   itemHospedagem.getHospedagem().getId());
        if ("update".equals(op)) {
            stmt.setLong(++i, itemHospedagem.getId());
        }
        stmt.executeUpdate();
    }
    
    public void delete(Long id) throws RepositoryException {
        try {
            if (connection.getConnectionContext() == null || connection.getConnectionContext().isClosed()) {
                connection.beginTransaction();
            }

            int i = 0;

            this.conn = connection.getConnectionFromContext();

            stmt = conn.prepareStatement("delete from item_hospedagens where itemhosp_id = ?",
                     PreparedStatement.RETURN_GENERATED_KEYS);
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
