package br.com.poo.controleHospedagem.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bruno.oliveira
 */
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Usuario {
        @Setter
        @Getter
	private Long id;
        
        @Setter
        @Getter
        private String usuario;
        
        @Setter
        @Getter
        private String senha;
    
}
