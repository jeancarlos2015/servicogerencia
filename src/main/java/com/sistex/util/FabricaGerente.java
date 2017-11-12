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
class FabricaGerente extends Fabrica {

    @Override
    public Gerente criaGerente(){
        return new Gerente();
    }
    
}
