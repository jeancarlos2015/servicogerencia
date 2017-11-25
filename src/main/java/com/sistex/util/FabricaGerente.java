package com.sistex.util;

import com.sistex.cdp.Gerente;

class FabricaGerente extends Fabrica {

    @Override
    public Gerente criaGerente() {
        return new Gerente();
    }

}
