/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cgd.NotificacaoRepositorio;
import static com.sistex.util.Tipo.DB;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jean
 */
public class NotificacaoDB extends NotificacaoChain{
    @Autowired
    private NotificacaoRepositorio notificacaoRepositorio;
    public NotificacaoDB() {
        super(DB);
    }
  
    @Override
    public void enviar() {
        notificacaoRepositorio.save(email.getNotificao());
    }
    
    
}
