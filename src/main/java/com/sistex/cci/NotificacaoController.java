/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Notificacao;
import com.sistex.cgt.NotificacaoChain;
import com.sistex.cgt.NotificacaoDB;
import com.sistex.cgt.NotificacaoEmail;
import com.sistex.cgt.NotificacaoServico;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.DB;
import static com.sistex.util.Tipo.EMAIL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
     @Autowired
    private NotificacaoDB notificacaoDB;
    @Autowired
    private NotificacaoEmail notificacaoEmail;
    
    private NotificacaoChain next;
    
    private Fabrica fabrica = Fabrica.make(EMAIL);
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Boolean excluir(@PathVariable("id") Long id) {
        notificacaoService.delete(id);
        return !notificacaoService.exist(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean cadastrar(@RequestBody Notificacao notificacao) {
        Notificacao novo = notificacaoService.save(notificacao);
        return notificacaoService.exist(novo.getIdnotificacao());
    }
    
    @RequestMapping(value="/acionar",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean acionarFornecedor(@RequestBody Notificacao notificacao) {
        EmailObj email = fabrica.criaEmail();
        email.setAssunto("Acionamento de fornecedor");
        email.setNotificao(notificacao);
        notificacaoDB.setEmail(email);
        notificacaoEmail.setEmail(email);
        next = notificacaoEmail;
        next.setNext(notificacaoDB);
        
        try {
            next.enviarNotiticacao(EMAIL);
            next.enviarNotiticacao(DB);
            return true;
        } catch (Exception e) {
            return false;
        }
        
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
    
    @RequestMapping(value = "/listar/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public List<Notificacao> listNotificacaoesNome(@PathVariable("nome") String email) {
        return notificacaoService.findAllByEmail(email);
    }
}
