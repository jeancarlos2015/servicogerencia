/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;



import com.sistex.cdp.Gerente;

/**
 *
 * @author jean
 */
public class Fabrica {
    public static Fabrica make(Tipo tipo){
        switch(tipo){
            case GERENTE:
                return new FabricaGerente();
            case NOTIFICACAO:
                return new FabricaNotificacao();
            case COMPRA:
                return new FabricaCompra();
            case VENDA:
                return new FabricaVenda();
            default:
                return new Fabrica();
                
        }
    }
    
   
    
    public Gerente criaGerente() {
        return null;
    }
   
    
}
