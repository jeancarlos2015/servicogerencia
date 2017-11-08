/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Notificacao;
import java.util.List;

/**
 *
 * @author jean
 */
public interface NotificacaoServicoDB {
    List<Notificacao> listAll();

    Notificacao getById(Long id);

    Notificacao getByRg(String rg);

    Notificacao update(Notificacao notificacao);

    void delete(Long id);

    Notificacao save(Notificacao notificacao);
    
    List<Notificacao> findAllByNome(String nome);
}
