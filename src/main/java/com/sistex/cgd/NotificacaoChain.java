/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.util.Tipo;

/**
 *
 * @author jean
 */
public class NotificacaoChain {
    protected NotificacaoChain next;
    protected Tipo idNotificacao;
    
    protected void setNext(NotificacaoChain next){
        this.next = next;
    }
    
    protected boolean podeEnviar(){
        return false;
    }
    
    protected void enviar(){
        
    }
    public NotificacaoChain(Tipo tipo){
        
    }
}
