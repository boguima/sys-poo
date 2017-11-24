package br.com.poo.controleHospedagem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Cliente {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String nomeCliente;
    @Getter
    @Setter
    private String endereco;
    @Getter
    @Setter
    private String uf;
    @Getter
    @Setter
    private String telefone;
    @Getter
    @Setter
    private String cpf;
    @Getter
    @Setter
    private String eMail;

    public Cliente(Long codigo) {
        this.id = codigo;
    }
}
