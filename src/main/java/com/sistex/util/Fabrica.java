/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Compra;
import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Fornecedor;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Gerente;
import com.sistex.cdp.Notificacao;

public class Fabrica {

    public static Fabrica make(Tipo tipo) {
        switch (tipo) {
            case GERENTE:
                return new FabricaGerente();
            case NOTIFICACAO:
                return new FabricaNotificacao();
            case COMPRA:
                return new FabricaCompra();
            case FORNECEDOR:
                return new FabricaFornecedor();
            case EMAIL:
                return new FabricaEmail();
            case FUNCIONARIO:
                return new FabricaFuncionario();

            default:
                return new Fabrica();

        }
    }

    public Gerente criaGerente() {
        return null;
    }

    public Funcionario criaFuncionario() {
        return null;
    }

    public Fornecedor criaFornecedor() {
        return null;
    }

    public Compra criaCompra() {
        return null;
    }

    public Notificacao criaNotificacao() {
        return null;
    }

    public EmailObj criaEmail() {
        return null;
    }

}
