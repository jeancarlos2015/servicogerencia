/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Notificacao;
import com.sistex.cgd.NotificacaoRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.NOTIFICACAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class NotificacaoServicoImpl implements NotificacaoServico{
    @Autowired
    private NotificacaoRepositorio notificacaoRepositorio;
    private final Fabrica fabrica = Fabrica.make(NOTIFICACAO);
    private NotificacaoChain notificacaoChain;
    
    @Override
    public List<Notificacao> listAll() {
        List<Notificacao> notificacoes = new ArrayList<>();
        notificacaoRepositorio.findAll().forEach(notificacoes::add);
        return notificacoes;
    }

    @Override
    public Notificacao getById(Long id) {
        return notificacaoRepositorio.findOne(id);
    }

 
    @Override
    public void delete(Long id) {
        if(notificacaoRepositorio.exists(id)){
            notificacaoRepositorio.delete(id);
        }
    }

    @Override
    public Notificacao save(Notificacao notificacao) {
        if(!notificacao.isEmpty()){
            return notificacaoRepositorio.save(notificacao);
        }
        return fabrica.criaNotificacao();
    }

    @Override
    public List<Notificacao> findAllByEmail(String email) {
        List<Notificacao> notificacoes = new ArrayList<>();
        notificacaoRepositorio.findAllByEmail(email);
        return notificacoes;
    }

    @Override
    public Boolean exist(Long id) {
        return notificacaoRepositorio.exists(id);
    }
    
}
