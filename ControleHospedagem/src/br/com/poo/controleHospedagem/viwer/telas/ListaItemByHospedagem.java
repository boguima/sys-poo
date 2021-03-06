/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.viwer.telas;

import br.com.poo.controleHospedagem.entity.Hospedagens;
import br.com.poo.controleHospedagem.entity.ItemHospedagem;
import br.com.poo.controleHospedagem.entity.Quarto;
import br.com.poo.controleHospedagem.entity.Repository.ItemHospedagenRepository;
import br.com.poo.controleHospedagem.entity.Repository.QuartoRepository;
import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.service.QuartoService;
import br.com.poo.controleHospedagem.service.UsuarioService;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lucas
 */
public class ListaItemByHospedagem extends javax.swing.JFrame {

    @Getter
    @Setter
    private Hospedagens entity = null;

    /**
     * Creates new form ListaQuarto
     */
    public ListaItemByHospedagem(int codigoHospedagem) throws RepositoryException {
        this.entity = new Hospedagens(codigoHospedagem);
        initComponents();

        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();

        for (ItemHospedagem item : new ItemHospedagenRepository().findByHopedagem(Long.valueOf(codigoHospedagem))) {
            mod.addRow(new Object[]{
                item.getId(),
                item.getHospedagem().getId(),
                item.getProduto(),
                item.getQtd(),
                item.getValorUnit()
            });
        }

    }

    public ListaItemByHospedagem() throws RepositoryException {

        initComponents();

        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();

        for (ItemHospedagem item : new ItemHospedagenRepository().findAll()) {
            mod.addRow(new Object[]{
                item.getId(),
                item.getHospedagem().getId(),
                item.getProduto(),
                item.getQtd(),
                item.getValorUnit()
            });
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Item", "ID Hospedagem", "Descrição", "Quantidade", "Valor Unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        mod.setNumRows(0);

        try {
            if (this.getEntity() != null) {
                for (ItemHospedagem item : new ItemHospedagenRepository().findByHopedagem(Long.valueOf(this.getEntity().getId()))) {
                    mod.addRow(new Object[]{
                        item.getId(),
                        item.getHospedagem().getId(),
                        item.getProduto(),
                        item.getQtd(),
                        item.getValorUnit()
                    });
                }

            } else {
                for (ItemHospedagem item : new ItemHospedagenRepository().findAll()) {
                    mod.addRow(new Object[]{
                        item.getId(),
                        item.getHospedagem().getId(),
                        item.getProduto(),
                        item.getQtd(),
                        item.getValorUnit()
                    });
                }
            }

        } catch (RepositoryException ex) {
            Logger.getLogger(ListaItemByHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaItemByHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaItemByHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaItemByHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaItemByHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListaItemByHospedagem().setVisible(true);
                } catch (RepositoryException ex) {
                    Logger.getLogger(ListaItemByHospedagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
