package com.sistex.cgt;

import com.sistex.cdp.EmailObj;
import com.sistex.cdp.Anexo;
import com.sistex.util.Tipo;
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

public class NotificacaoEmail extends NotificacaoChain {

    public NotificacaoEmail() {
        super(EMAIL);
    }

    public void enviaEmailSimples(EmailObj emailobj) throws EmailException {

        SimpleEmail email1 = new SimpleEmail();
        email1.setHostName(emailobj.getHost());
        email1.addTo(emailobj.getDestinatario(), emailobj.getAssunto()); //destinatário
        email1.setFrom(emailobj.getRemetente(), emailobj.getNotificao().getNomeCliente()); // remetente
        email1.setSubject("Solicitação de material"); // assunto do e-mail
        email1.setMsg(emailobj.getNotificao().getDescricao()); //conteudo do e-mail
        email1.send(); //envia o e-mail
    }

    public void enviaEmailAnexo(Anexo anexo) throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(anexo.getCaminho()); //caminho da imagem
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(anexo.getDescricao());
        attachment.setName(anexo.getNomeArquivo());

        MultiPartEmail email1 = new MultiPartEmail();
        email1.setHostName(anexo.getEmail().getHost()); // o servidor SMTP para envio do e-mail
        email1.addTo(anexo.getEmail().getDestinatario(), anexo.getEmail().getNomeRemetente()); //destinatario
        email1.setFrom(anexo.getEmail().getRemetente(), anexo.getEmail().getNomeDestinatario()); //remetente
        email1.setSubject(anexo.getDescricao()); //Assunto
        email1.setMsg(anexo.getDescricao()); //conteudo do e-mail
        email1.attach(attachment); // adiciona o anexo à mensagem

        email1.send();// envia o e-mail

    }

    public void enviaEmailHtml(EmailObj emailObj) throws EmailException, MalformedURLException {
        HtmlEmail email1 = new HtmlEmail();
        email1.setHostName(emailObj.getHost());
        email1.addTo(emailObj.getDestinatario(), emailObj.getNomeDestinatario());
        email1.setFrom(emailObj.getRemetente(), emailObj.getNomeRemetente());
        email1.setSubject(emailObj.getAssunto());

// adiciona uma imagem ao corpo da mensagem e retorna seu id
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        String cid = email1.embed(url, "Apache logo");

// configura a mensagem para o formato HTML
        email1.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");

// configure uma mensagem alternativa caso o servidor não suporte HTML
        email1.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");

// envia o e-mail
        email1.send();

    }

    public boolean podeEnviarNotificacaoDB(Tipo id) {
        return id == EMAIL;
    }

    @Override
    public void enviar() {

        try {
            enviaEmailHtml(email);
        } catch (EmailException | MalformedURLException ex) {
            Logger.getLogger(NotificacaoEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
