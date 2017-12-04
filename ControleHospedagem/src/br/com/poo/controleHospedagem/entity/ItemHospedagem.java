package br.com.poo.controleHospedagem.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemHospedagem {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String produto;
    @Getter
    @Setter
    private int qtd;
    @Getter
    @Setter
    private Double valorUnit;
    @Getter
    @Setter
    private Hospedagens hospedagem;
    
    public ItemHospedagem(Long id, String produto, int qtd, Double valorUnit, int codigoHopedagem){
    this.setId(id);
    this.setProduto(produto);
    this.setQtd(qtd);
    this.setValorUnit(valorUnit);
    this.setHospedagem(new Hospedagens(codigoHopedagem));
    }
}
