/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Anexo;
import static com.sistex.util.Tipo.EMAIL;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class NotificacaoEmail extends NotificacaoChain{
    
    
    public NotificacaoEmail() {
        super(EMAIL);
    }
    
    public void enviaEmailSimples(EmailObj emailobj) throws EmailException {
        
        SimpleEmail email = new SimpleEmail();
        email.setHostName(emailobj.getHost());
        email.addTo(emailobj.getDestinatario(), emailobj.getAssunto()); //destinatário
        email.setFrom(emailobj.getRemetente(), emailobj.getNotificao().getNomeCliente()); // remetente
        email.setSubject("Solicitação de material"); // assunto do e-mail
        email.setMsg(emailobj.getNotificao().getDescricao()); //conteudo do e-mail
        email.send(); //envia o e-mail
    }

    public void enviaEmailAnexo(Anexo anexo) throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(anexo.getCaminho()); //caminho da imagem
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(anexo.getDescricao());
        attachment.setName(anexo.getNomeArquivo());

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(anexo.getEmail().getHost()); // o servidor SMTP para envio do e-mail
        email.addTo(anexo.getEmail().getDestinatario(), anexo.getEmail().getNomeRemetente()); //destinatario
        email.setFrom(anexo.getEmail().getRemetente(), anexo.getEmail().getNomeDestinatario()); //remetente
        email.setSubject(anexo.getDescricao()); //Assunto
        email.setMsg(anexo.getDescricao()); //conteudo do e-mail
        email.attach(attachment); // adiciona o anexo à mensagem

        email.send();// envia o e-mail

    }

    public void enviaEmailHtml(EmailObj emailObj) throws EmailException, MalformedURLException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(emailObj.getHost());
        email.addTo(emailObj.getDestinatario(), emailObj.getNomeDestinatario());
        email.setFrom(emailObj.getRemetente(), emailObj.getNomeRemetente());
        email.setSubject(emailObj.getAssunto());

// adiciona uma imagem ao corpo da mensagem e retorna seu id
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        String cid = email.embed(url, "Apache logo");

// configura a mensagem para o formato HTML
        email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");

// configure uma mensagem alternativa caso o servidor não suporte HTML
        email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");

// envia o e-mail
        email.send();

    }

    @Override
    public void enviar() {
        try {
            enviaEmailHtml(email);
        } catch (EmailException ex) {
            Logger.getLogger(NotificacaoEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NotificacaoEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
