package br.com.poo.controleHospedagem.service;

import br.com.poo.controleHospedagem.entity.Cliente;
import br.com.poo.controleHospedagem.entity.Repository.ClienteRepository;

public class ClienteServiceImpl{

	public void novoCliente (Cliente cliente) {
		try {
			(new ClienteRepository()).inserir(cliente);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
