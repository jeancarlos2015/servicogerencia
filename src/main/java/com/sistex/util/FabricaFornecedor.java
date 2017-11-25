package com.sistex.util;

import com.sistex.cdp.Fornecedor;

public class FabricaFornecedor extends Fabrica {

    @Override
    public Fornecedor criaFornecedor() {
        return new Fornecedor();
    }
}
