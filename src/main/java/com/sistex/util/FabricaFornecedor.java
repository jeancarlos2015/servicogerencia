/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Fornecedor;
import com.sistex.util.Fabrica;

/**
 *
 * @author jean
 */
public class FabricaFornecedor extends Fabrica{
    @Override
    public Fornecedor criaFornecedor(){
        return new Fornecedor();
    }
}
