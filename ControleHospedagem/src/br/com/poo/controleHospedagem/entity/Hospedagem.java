package br.com.poo.controleHospedagem.entity;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode @ToString
public class Hospedagem {
	@Getter @Setter
	private int idhosp;
	@Getter @Setter
	private int numQuarto;
	@Getter @Setter
	private Date dataEntrada;
	@Getter @Setter
	private Date dataSaida;
	@Getter @Setter
	private Cliente cliente;
	@Getter @Setter
	private char checkout;
	@Getter @Setter
	private String observacao;
}
