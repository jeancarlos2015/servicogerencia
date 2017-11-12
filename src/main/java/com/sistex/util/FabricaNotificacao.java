/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Notificacao;

/**
 *
 * @author jean
 */
class FabricaNotificacao extends Fabrica {

   
    @Override
    public Notificacao criaNotificacao(){
        return new Notificacao();
    }
    
}
