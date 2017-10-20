package br.com.poo.controleHospedagem.entity;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode @ToString
public class ItemHospedagem {
	@Getter @Setter
	private int iditem;
	@Getter @Setter
	private String produto;
	@Getter @Setter
	private int qtd;
	@Getter @Setter
	private BigDecimal valorUnit;
	@Getter @Setter
	private Hospedagens hospedagem; 
}
