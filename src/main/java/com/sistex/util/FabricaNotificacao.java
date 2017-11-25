package com.sistex.util;

import com.sistex.cdp.Notificacao;

class FabricaNotificacao extends Fabrica {

    @Override
    public Notificacao criaNotificacao() {
        return new Notificacao();
    }

}
