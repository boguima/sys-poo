/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.viwer.telas;

import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.service.ClienteServiceImpl;
import br.com.poo.controleHospedagem.service.UsuarioService;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.awt.Component;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class CadastoUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastoUsuario
     */
    public CadastoUsuario() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        codigoUsuarioLoc = new javax.swing.JTextField();
        btLocalizar = new javax.swing.JButton();
        btRecarregar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Usuário");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Dados do Usuário");

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btCadastrar.setText("Cadastrar/Editar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Código:");

        codigo.setEnabled(false);

        jLabel10.setText("Login:");

        jLabel11.setText("Senha:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btExcluir)
                                .addGap(46, 46, 46)
                                .addComponent(btCadastrar)))))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btCadastrar))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Código do Usuario:");

        codigoUsuarioLoc.setToolTipText("Digite o Código");

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

        btConsultar.setText("Listar Usuários");
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
                .addComponent(codigoUsuarioLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(codigoUsuarioLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRecarregar)
                    .addComponent(btConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO Remove Cliente
        try {
            if (!"".equals(codigo.getText())) {
                (new UsuarioService()).delete(Long.parseLong(codigo.getText()));
                JOptionPane.showMessageDialog(null, "Operação Concluída com Sucesso", "OK", JOptionPane.INFORMATION_MESSAGE);
                refreshScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Obrigatório localizar Usuário","Remoção",  JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao remover o Usuário","Remoção",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

        private void refreshScreen() {
        codigoUsuarioLoc.setText("");
        codigo.setText("");
        
        btLocalizar.setEnabled(true);
        btExcluir.setEnabled(false);
        btCadastrar.setEnabled(true);
        codigoUsuarioLoc.setEnabled(true);
    }
        
    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO Metodo Para Cadastrar e Atualizar CLiente
       try{
            if (codigo.getText().equals("")) {
                try{
                   if (validaCamposObrigatorios()) {
                        JOptionPane.showMessageDialog(null, "Campos para cadastro ", "Atenção",  JOptionPane.ERROR_MESSAGE);
                        codigoUsuarioLoc.setEnabled(false);
                        codigoUsuarioLoc.setText("");
                        btLocalizar.setEnabled(false);
                    } else {
                        (new UsuarioService()).inserir(new Usuario(0L,jTextField1.getText(), jTextField2.getText()));
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
                        codigoUsuarioLoc.setEnabled(false);
                        codigoUsuarioLoc.setText("");
                        btLocalizar.setEnabled(false);
                    } else {
                        (new UsuarioService()).update(new Usuario(Long.parseLong(codigo.getText()),jTextField1.getText(),jTextField2.getText()));
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
        return jTextField1.getText().equals("")||jTextField2.getText().equals("");
    }
        
    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        if (!codigoUsuarioLoc.getText().equals("")) {
            Usuario usuario = null;
            try {
                usuario = (new UsuarioService()).findOne(codigoUsuarioLoc.getText());
            } catch (RepositoryException ex) {
                Logger.getLogger(CadastoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (usuario != null) {
                codigo.setText(usuario.getId().toString());
                btExcluir.setEnabled(true);
            } else {
                codigoUsuarioLoc.setText("");
                JOptionPane.showMessageDialog(null, "Usuaári não localizado", "Atenção",  JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informar Código do Usuário", "Atenção",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecarregarActionPerformed
        refreshScreen();
    }//GEN-LAST:event_btRecarregarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
    
     ListaUsuario form = null;
        try {
            form = new ListaUsuario();
            
        } catch (RepositoryException ex) {
            Logger.getLogger(CadastoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
      form.setVisible(true);
        
        
    }//GEN-LAST:event_btConsultarActionPerformed
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btRecarregar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigoUsuarioLoc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
