/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Compra;

/**
 *
 * @author jean
 */
class FabricaCompra extends Fabrica {

    public FabricaCompra() {
    }

    public Compra criaCompra(){
        return new Compra();
    }
}
