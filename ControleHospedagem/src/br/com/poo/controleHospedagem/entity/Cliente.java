package br.com.poo.controleHospedagem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode @ToString
public class Cliente {
	@Getter @Setter
	private Long id;
	@Getter @Setter
	private String nomeCliente;
	@Getter @Setter
	private String endereco;
	@Getter @Setter
	private String uf;
	@Getter @Setter
	private String telefone;
	@Getter @Setter
	private String cpf;
	@Getter @Setter
	private String eMail;
	
	public Cliente(String nomeCliente, String endereco, String uf, String telefone, String cpf, String eMail) {
		super();
		this.setNomeCliente(nomeCliente);
		this.setEndereco(endereco);
		this.setUf(uf);;
		this.setTelefone(telefone);
		this.setCpf(cpf);
		this.setEMail(eMail);
	}
	
}
