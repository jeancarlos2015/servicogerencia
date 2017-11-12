/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.EmailObj;
import com.sistex.util.Tipo;

/**
 *
 * @author jean
 */
public abstract class NotificacaoChain {
    protected NotificacaoChain next;
    protected Tipo idNotificacao;
    protected EmailObj email;
    protected void setNext(NotificacaoChain forma){
        if(next==null){
            next  = forma;
        }else{
            next.setNext(forma);
        }
    }
    public boolean podeEnviar(Tipo tipo){
        return idNotificacao == tipo;
    }
    
    public void enviarNotiticacao(Tipo tipo){
        if(podeEnviar(tipo)){
            enviar();
        }else{
            if(next != null){
                next.enviarNotiticacao(tipo);
            }
        }
    }
   
    
    public NotificacaoChain(Tipo tipo){
        next = null;
        idNotificacao = tipo;
    }

   
    
     public abstract void enviar();
     
     
    public EmailObj getEmail() {
        return email;
    }

    public void setEmail(EmailObj email) {
        this.email = email;
    }
}