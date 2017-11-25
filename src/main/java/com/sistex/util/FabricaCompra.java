package com.sistex.util;

import com.sistex.cdp.Compra;

class FabricaCompra extends Fabrica {

    @Override
    public Compra criaCompra() {
        return new Compra();
    }
}
