/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.service;

import br.com.poo.controleHospedagem.entity.Quarto;
import br.com.poo.controleHospedagem.entity.Repository.QuartoRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;

/**
 *
 * @author bruno.oliveira
 */
public class QuartoService  extends QuartoRepository{
    
    public Quarto findOneQuarto(Long codigo) throws RepositoryException{
        return super.findOne(codigo);
    }
    
}
