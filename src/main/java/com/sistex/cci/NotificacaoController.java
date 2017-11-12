/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Notificacao;
import com.sistex.cgt.NotificacaoServico;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jean
 */
@Controller
@RequestMapping("/notificacao")
public class NotificacaoController {
    private NotificacaoServico notificacaoService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        notificacaoService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Notificacao cadastrar(@RequestBody EmailObj emailObj) {
        return notificacaoService.save(emailObj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Notificacao buscarNotificacao(@PathVariable("id") String id) {
        return notificacaoService.getById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Notificacao> listNotificacaos() {
        return notificacaoService.listAll();
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
    @ResponseBody
    public List<Notificacao> listNotificacaoesNome(@PathVariable("nome") String email) {
        return notificacaoService.findAllByEmail(email);
    }
}
