package com.sistex.cgt;

import com.sistex.cdp.Notificacao;
import java.util.List;

public interface NotificacaoServico {

    List<Notificacao> listAll();

    Notificacao getById(Long id);

    void delete(Long id);

    Notificacao save(Notificacao notificacao);

    List<Notificacao> findAllByEmail(String email);

    Boolean exist(Long id);
}
