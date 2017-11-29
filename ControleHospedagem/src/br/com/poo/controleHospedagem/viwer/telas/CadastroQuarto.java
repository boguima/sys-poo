/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.viwer.telas;


import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Quarto;
import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.service.ClienteServiceImpl;
import br.com.poo.controleHospedagem.service.QuartoService;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class CadastroQuarto extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroCliente
     */
    public CadastroQuarto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        codigoClienteLoc = new javax.swing.JTextField();
        btLocalizar = new javax.swing.JButton();
        btRecarregar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setClosable(true);
        setTitle("Cadastro de Cliente");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Dados do Quarto");
        jLabel4.setMaximumSize(new java.awt.Dimension(320, 44));
        jLabel4.setMinimumSize(new java.awt.Dimension(320, 44));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/group_delete.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/group_edit.png"))); // NOI18N
        btCadastrar.setText("Cadastrar/Editar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Código:");

        codigo.setEnabled(false);

        jLabel11.setText("Descrição:");

        jLabel12.setText("Situação:");

        jLabel13.setText("Valor:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DC", "OC" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btExcluir)
                        .addGap(53, 53, 53)
                        .addComponent(btCadastrar)
                        .addContainerGap(277, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btCadastrar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Código do Quarto:");

        codigoClienteLoc.setToolTipText("Digite o Código");

        btLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/connect.png"))); // NOI18N
        btLocalizar.setText("Localizar");
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        btRecarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/arrow_refresh.png"))); // NOI18N
        btRecarregar.setText("Recarregar Tela");
        btRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecarregarActionPerformed(evt);
            }
        });

        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/database.png"))); // NOI18N
        btConsultar.setText("Listar Quartos");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codigoClienteLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btLocalizar)
                .addContainerGap(235, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btConsultar)
                .addGap(18, 18, 18)
                .addComponent(btRecarregar)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(codigoClienteLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRecarregar)
                    .addComponent(btConsultar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO Remove Cliente
try {
            if (!"".equals(codigo.getText())) {
                (new QuartoService()).delete(Long.parseLong(codigo.getText()));
                JOptionPane.showMessageDialog(null, "Operação Concluída com Sucesso", "OK", JOptionPane.INFORMATION_MESSAGE); 
                refreshScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Obrigatório localizar quarto","Remoção",  JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao remover o quarto","Remoção",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO Metodo Para Cadastrar e Atualizar CLiente
        try{
        if (codigo.getText().equals("")) {
            try{
            if (validaCamposObrigatorios()) {
                JOptionPane.showMessageDialog(null, "Campos para cadastro são obrigatórios", "Atenção",  JOptionPane.ERROR_MESSAGE);
                codigoClienteLoc.setEnabled(false);
                codigoClienteLoc.setText("");
                btLocalizar.setEnabled(false);
            } else {
                (new QuartoService()).inserir(new Quarto(0L,jTextField1.getText(),String.valueOf(jComboBox1.getSelectedIndex()) ,BigDecimal.valueOf(Float.parseFloat(jTextField2.getText()))));
                         jTextField1.setText("");
                         jTextField2.setText("");
            }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"Houve um erro no Cadastro","Cadastro",JOptionPane.ERROR_MESSAGE);
             }
        } else {
            try{
            if (validaCamposObrigatorios()) {
                JOptionPane.showMessageDialog(null, "Campos para cadastro são obrigatórios", "Atenção",  JOptionPane.ERROR_MESSAGE);
                codigoClienteLoc.setEnabled(false);
                codigoClienteLoc.setText("");
                btLocalizar.setEnabled(false);
            } else {
            (new QuartoService()).update(new Quarto(Long.valueOf(codigo.getText()),jTextField1.getText(),String.valueOf(jComboBox1.getSelectedIndex()) ,BigDecimal.valueOf(Float.parseFloat(jTextField2.getText())))); 
              jTextField1.setText("");
              jTextField2.setText("");
            }            
            //JOptionPane.showMessageDialog(null,"Operação Concluída com Sucesso","Alteração",JOptionPane.INFORMATION_MESSAGE);                
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"Houve um erro na alteração","Alteração",JOptionPane.ERROR_MESSAGE);
             }
        }
        JOptionPane.showMessageDialog(null,"Operação Concluída com Sucesso","OK",JOptionPane.INFORMATION_MESSAGE); 
        refreshScreen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Houve um erro","Atenção",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private boolean validaCamposObrigatorios() {
        return jTextField1.getText().equals("") || jTextField2.getText().equals("") ;
    }

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        if (!codigoClienteLoc.getText().equals("")) {
        Quarto quartos = null;
            try {
                quartos = (new QuartoService().findOne(Long.parseLong(codigoClienteLoc.getText())));
            } catch (RepositoryException ex) {
                Logger.getLogger(CadastroQuarto.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (quartos != null) {
                codigo.setText(quartos.getId().toString());
                jTextField1.setText(quartos.getDescricao());
                jComboBox1.setSelectedIndex(Integer.parseInt(quartos.getSituacao()));
                jTextField2.setText(String.valueOf(quartos.getValorDia()));
              
                btExcluir.setEnabled(true);                
            } else {
            codigoClienteLoc.setText("");
            JOptionPane.showMessageDialog(null, "Quarto não localizado", "Atenção",  JOptionPane.ERROR_MESSAGE);
            }            
        } else {
            JOptionPane.showMessageDialog(null, "Informar Código do Quarto", "Atenção",  JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        ListaQuarto form = null;
        try {
            form = new ListaQuarto();
        } catch (RepositoryException ex) {
            Logger.getLogger(CadastroQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecarregarActionPerformed
    refreshScreen();
    }//GEN-LAST:event_btRecarregarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void refreshScreen() {
        codigoClienteLoc.setText("");
        codigo.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
       
        
        btLocalizar.setEnabled(true);
        btExcluir.setEnabled(false);
        btCadastrar.setEnabled(true);
        codigoClienteLoc.setEnabled(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btRecarregar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigoClienteLoc;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}