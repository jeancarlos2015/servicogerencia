/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Sugestao;
import com.sistex.cgt.NotificacaoEmail;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.EMAIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/sugestao")
public class EmailController {
    @Autowired
    private NotificacaoEmail notificacaoEmail;
    
    private final Fabrica fabrica = Fabrica.make(EMAIL);
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean enviarEmail(@RequestBody Sugestao sugestao) {
        EmailObj email = fabrica.criaEmail();
        email.setAssunto(sugestao.getNome());
        email.setTexto("telefone: "+sugestao.getTelefone()+"   sugestao: "+sugestao.getSugestao());
        return notificacaoEmail.enviaEmailSimples(email);
    }
}
