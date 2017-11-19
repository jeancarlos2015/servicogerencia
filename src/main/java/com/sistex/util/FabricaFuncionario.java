/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Funcionario;

/**
 *
 * @author jean
 */
public class FabricaFuncionario extends Fabrica {

    @Override
    public Funcionario criaFuncionario() {
        return new Funcionario();
    }
}
