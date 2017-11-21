/*
 * ClienteTableModel.java
 *
 * Created on 5 de Janeiro de 2009, 16:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.poo.controleHospedagem.entity.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.poo.controleHospedagem.entity.Cliente;

/**
 *
 * @author Portugal
 */
public class ClienteTableModel extends AbstractTableModel{
    
    /** Creates a new instance of ClienteTableModel */
    public ClienteTableModel() {
    }
    
    private List<Cliente> clientes;   
  
      public void setClientes(List<Cliente> clientes) {   
         this.clientes = clientes;   
      }   
  
      public int getColumnCount() {   
         return 3;   
      }   
  
      @Override  
      public String getColumnName(int col) {   
         switch (col) {   
            case 0:   
               return "Codigo";   
            case 1:   
               return "Nome";   
            case 2:   
               return "Endereco";   
            default:   
               return null;   
         }   
      }   
  
      public int getRowCount() {   
         return clientes != null  
            ? clientes.size()   
            : 0;   
      }   
  
      public Object getValueAt(int lin, int col) {   
         if (clientes != null && lin >= 0 && lin < clientes.size()) {   
            Cliente cliente = clientes.get(lin);   
            switch (col) {   
               case 0:   
                  return cliente.getId();   
               case 1:   
                  return cliente.getNomeCliente();   
               case 2:   
                  return cliente.getEndereco();   
            }   
         }   
         return null;   
      }  
}
