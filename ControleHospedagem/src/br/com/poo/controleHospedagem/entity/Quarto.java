/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bruno.oliveira
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quarto {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String situacao;
    @Getter
    @Setter
    private BigDecimal valorDia;

    public Quarto(Long codigo) {
        this.id = codigo;
    }
}
