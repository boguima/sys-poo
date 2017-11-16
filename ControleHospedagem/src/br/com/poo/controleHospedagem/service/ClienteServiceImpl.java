package br.com.poo.controleHospedagem.service;

import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Repository.ClienteRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteServiceImpl{

	public void novoCliente (Cliente cliente) {
		try {
                    Cliente entity = cliente;
                    entity.setCpf(entity.getCpf().replace(".", "").replace("-", ""));
                    entity.setTelefone(entity.getTelefone().replace("(", "").replace(")", "").replace("-", ""));
			(new ClienteRepository()).inserir(entity);
		} catch (RepositoryException ex) {
			// TODO: handle exception
		}
	}
        
        public Cliente findOne (Long codigo) {
            Cliente entity = null;
            try {
               entity = (new ClienteRepository()).findOne(codigo);
            } catch (RepositoryException ex) {
            }
            return entity;
        }
	
}
