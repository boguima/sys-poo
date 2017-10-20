package br.com.poo.controleHospedagem.entity;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Hospedagens {
	@Getter
	@Setter
	private int idhosp;
	@Getter
	@Setter
	private int numQuarto;
	@Getter
	@Setter
	private Date dataEntrada;
	@Getter
	@Setter
	private Date dataSaida;
	@Getter
	@Setter
	private Cliente cliente;
	@Getter
	@Setter
	private String stCheckout;
	@Getter
	@Setter
	private String observacao;
}
