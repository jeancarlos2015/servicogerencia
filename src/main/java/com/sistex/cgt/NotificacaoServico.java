/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Notificacao;
import java.util.List;

/**
 *
 * @author jean
 */
public interface NotificacaoServico {
    List<Notificacao> listAll();

    Notificacao getById(Long id);

    void delete(Long id);

    Notificacao save(Notificacao notificacao);
    
    List<Notificacao> findAllByEmail(String email);
}
