package br.com.poo.controleHospedagem.entity;

import java.beans.Transient;
import java.util.Date;
import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"dataEntradaAux", "dataSaidaAux"})
public class Hospedagens {

    @Getter
    @Setter
    private int id;
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
    @Getter
    @Setter
    private Quarto quarto;
    @Getter
    @Setter
    private String dataEntradaAux;
    @Getter
    @Setter
    private String dataSaidaAux;
}
