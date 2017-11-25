package com.sistex.util;

import com.sistex.cdp.EmailObj;

public class FabricaEmail extends Fabrica {

    @Override
    public EmailObj criaEmail() {
        return new EmailObj();
    }
}
