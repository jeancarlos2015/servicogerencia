package com.sistex.util;

import com.sistex.cdp.Funcionario;

public class FabricaFuncionario extends Fabrica {

    @Override
    public Funcionario criaFuncionario() {
        return new Funcionario();
    }
}
