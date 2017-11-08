/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Notificacao;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMail {

    private Notificacao notificacao;
    private String host;
    public CommonsMail() throws EmailException, MalformedURLException {
        
    }
    public CommonsMail(Notificacao notificacao) throws EmailException, MalformedURLException {
        this.notificacao = notificacao;
    }
    
    public void enviaEmailSimples(Notificacao notificacao) throws EmailException {
        if (notificacao.getEmail().toLowerCase().contains("gmail")) {
            host = "smtp.googlemail.com";
        } else if (notificacao.getEmail().toLowerCase().contains("hotmail")) {
            host = "smtp.live.com";
        }
        SimpleEmail email = new SimpleEmail();
        email.setHostName(host);
        email.addTo(notificacao.getEmail(), notificacao.getNomeCliente()); //destinatário
        email.setFrom("jeancarlospenas25@gmail.com", "Desenvolvedor"); // remetente
        email.setSubject("Solicitação de material"); // assunto do e-mail
        email.setMsg(notificacao.getDescricao()); //conteudo do e-mail
        email.send(); //envia o e-mail
    }

    /**
     * envia email com arquivo anexo
     *
     * @throws EmailException
     */
    public void enviaEmailComAnexo() throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("mypictures/john.jpg"); //caminho da imagem
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of John");
        attachment.setName("John");

// Cria a mensagem de e-mail.
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("mail.myserver.com"); // o servidor SMTP para envio do e-mail
        email.addTo("jdoe@somewhere.org", "John Doe"); //destinatario
        email.setFrom("me@apache.org", "Me"); //remetente
        email.setSubject("Mensagem de teste com anexo"); //Assunto
        email.setMsg("Aqui está a Imagem anexada ao e-mail"); //conteudo do e-mail
        email.attach(attachment); // adiciona o anexo à mensagem

        email.send();// envia o e-mail

    }

    /**
     * Envia email no formato HTML
     *
     * @throws EmailException
     * @throws MalformedURLException
     */
    public void enviaEmailFormatoHtml() throws EmailException, MalformedURLException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("mail.myserver.com");
        email.addTo("jdoe@somewhere.org", "John Doe");
        email.setFrom("me@apache.org", "Me");
        email.setSubject("Teste de e-mail em formato HTML");

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

    /**
     * @param args
     * @throws EmailException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws EmailException, MalformedURLException {
        new CommonsMail();
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
