/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.controleHospedagem.service;

import br.com.poo.controleHospedagem.entity.Usuario;
import br.com.poo.controleHospedagem.entity.Repository.UsuarioRepository;
import br.com.poo.controleHospedagem.util.RepositoryException;

/**
 *
 * @author bruno.oliveira
 */
public class LoginService  extends UsuarioRepository{
    
    public Usuario findOneLogin(String usuario) throws RepositoryException{
        return super.findOne(usuario);
    }
    
}
