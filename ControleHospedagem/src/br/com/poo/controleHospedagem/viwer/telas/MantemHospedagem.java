/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.viwer.telas;


import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Quarto;
import br.com.poo.controleHospedagem.entity.Repository.QuartoRepository;
import br.com.poo.controleHospedagem.service.ClienteServiceImpl;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brnuno
 */
public class MantemHospedagem extends javax.swing.JInternalFrame {
    @Getter
    @Setter
    private Cliente cliente;
    
    @Getter
    @Setter
    private Quarto quarto;

    /**
     * Creates new form CadastroCliente
     */
    public MantemHospedagem() {
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
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        codigoHospedagem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btRecarregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        codigoClienteLoc = new javax.swing.JTextField();
        btLocalizar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        nomeCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        codigoQuarto = new javax.swing.JTextField();
        btLocalizarQuarto = new javax.swing.JButton();
        btConsultarQuarto = new javax.swing.JButton();
        dsQuarto = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        btLocalizarHospedagem = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gestão de Hospedagem");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("Nome:");

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Dados da Hospedgem");
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
        btCadastrar.setEnabled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Código:");

        codigoHospedagem.setEnabled(false);
        codigoHospedagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoHospedagemActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btExcluir)
                                .addGap(53, 53, 53)
                                .addComponent(btCadastrar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(codigoHospedagem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(codigoHospedagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(168, 168, 168)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btCadastrar))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        btRecarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/arrow_refresh.png"))); // NOI18N
        btRecarregar.setText("Recarregar Tela");
        btRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecarregarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Código do Cliente:");

        codigoClienteLoc.setToolTipText("Digite o Código");

        btLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/connect.png"))); // NOI18N
        btLocalizar.setText("Localizar");
        btLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarActionPerformed(evt);
            }
        });

        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/database.png"))); // NOI18N
        btConsultar.setText("Listar Clientes");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        nomeCliente.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Código do Quarto");

        codigoQuarto.setToolTipText("Digite o Código");
        codigoQuarto.setEnabled(false);

        btLocalizarQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/connect.png"))); // NOI18N
        btLocalizarQuarto.setText("Localizar");
        btLocalizarQuarto.setEnabled(false);
        btLocalizarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarQuartoActionPerformed(evt);
            }
        });

        btConsultarQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/database.png"))); // NOI18N
        btConsultarQuarto.setText("Listar Clientes");
        btConsultarQuarto.setEnabled(false);
        btConsultarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarQuartoActionPerformed(evt);
            }
        });

        dsQuarto.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigoClienteLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btLocalizar))
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btLocalizarQuarto))
                    .addComponent(dsQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btConsultar)
                    .addComponent(btConsultarQuarto))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(codigoClienteLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocalizar)
                    .addComponent(btConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(codigoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocalizarQuarto)
                    .addComponent(btConsultarQuarto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dsQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Código Hospedagem:");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        btLocalizarHospedagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/poo/controleHospedagem/viwer/icons/iconsPNG/connect.png"))); // NOI18N
        btLocalizarHospedagem.setText("Localizar");
        btLocalizarHospedagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalizarHospedagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLocalizarHospedagem)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLocalizarHospedagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btRecarregar))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRecarregar)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean validaCamposObrigatorios() {
        return nome.getText().equals("");
    }

    private void btLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarActionPerformed
        if (!codigoClienteLoc.getText().equals("")) {
        this.cliente = (new ClienteServiceImpl()).findOne(Long.parseLong(codigoClienteLoc.getText()));
            if (this.cliente != null) {
                nomeCliente.setText(this.cliente.getNomeCliente());
                codigoQuarto.setEnabled(true);
                btLocalizarQuarto.setEnabled(true);
                btConsultarQuarto.setEnabled(true);
            } else {
            codigoClienteLoc.setText("");
            JOptionPane.showMessageDialog(null, "Cliente não localizado", "Atenção",  JOptionPane.ERROR_MESSAGE);
            }            
        } else {
            JOptionPane.showMessageDialog(null, "Informar Código do Cliente", "Atenção",  JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btLocalizarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        ListaClientes form = new ListaClientes();
        form.setVisible(true);
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecarregarActionPerformed
    refreshScreen();
    }//GEN-LAST:event_btRecarregarActionPerformed

    private void btLocalizarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarQuartoActionPerformed
        if (codigoQuarto != null) {
            try {
                this.quarto = (new QuartoRepository()).findOne(Long.parseLong(codigoQuarto.getText()));
                if (this.quarto != null) {
                   dsQuarto.setText(this.quarto.getDescricao());
                   btCadastrar.setEnabled(true);
                }
                
            } catch (RepositoryException ex) {
                Logger.getLogger(MantemHospedagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informar Código do Quarto", "Atenção",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btLocalizarQuartoActionPerformed

    private void btConsultarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarQuartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConsultarQuartoActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void btLocalizarHospedagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalizarHospedagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLocalizarHospedagemActionPerformed

    private void codigoHospedagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoHospedagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoHospedagemActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO Metodo Para Cadastrar e Atualizar CLiente
        try{
            if (codigoHospedagem.getText().equals("")) {
                try{
                    if (validaCamposObrigatorios()) {
                        JOptionPane.showMessageDialog(null, "Campos para cadastro são obrigatórios", "Atenção",  JOptionPane.ERROR_MESSAGE);
                        codigoClienteLoc.setEnabled(false);
                        codigoClienteLoc.setText("");
                        btLocalizar.setEnabled(false);
                    } else {
//                        Cliente cliente = new Cliente(null, nome.getText(), endereco.getText(), (String) uf.getSelectedItem(), telefone.getText(), cpf.getText(), email.getText());

                        (new ClienteServiceImpl()).novoCliente(cliente);
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
//                        (new ClienteServiceImpl()).update(new Cliente(Long.parseLong(codigoHospedagem.getText()), nome.getText(), endereco.getText(), (String) uf.getSelectedItem(), telefone.getText(), cpf.getText(), email.getText()));
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

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO Remove Cliente
        try {
            if (!"".equals(codigoHospedagem.getText())) {
                (new ClienteServiceImpl()).deleteCliente(Long.parseLong(codigoHospedagem.getText()));
                JOptionPane.showMessageDialog(null, "Operação Concluída com Sucesso", "OK", JOptionPane.INFORMATION_MESSAGE);
                refreshScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Obrigatório localizar cliente","Remoção",  JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao remover o cliente","Remoção",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void refreshScreen() {
        codigoClienteLoc.setText("");
        codigoHospedagem.setText("");
        nome.setText("");
        
        btLocalizar.setEnabled(true);
        btExcluir.setEnabled(false);
        btCadastrar.setEnabled(true);
        codigoClienteLoc.setEnabled(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btConsultarQuarto;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLocalizar;
    private javax.swing.JButton btLocalizarHospedagem;
    private javax.swing.JButton btLocalizarQuarto;
    private javax.swing.JButton btRecarregar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigoClienteLoc;
    private javax.swing.JTextField codigoHospedagem;
    private javax.swing.JTextField codigoQuarto;
    private javax.swing.JTextField dsQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomeCliente;
    // End of variables declaration//GEN-END:variables
}
