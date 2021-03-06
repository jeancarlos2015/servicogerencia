package com.sistex.cdp;
import jdk.nashorn.internal.ir.annotations.Ignore;
@Ignore
public class EmailObj {

    private String host = "smtp.gmail.com";
    private String port = "587";
    private String assunto="";
    private String texto="";
    private String destinatario="jeancarlospenas25@gmail.com";
    private String remetente="jeancarlospenas25@gmail.com";
    private Notificacao notificao;
    private String nomeRemetente;
    private String nomeDestinatario;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public Notificacao getNotificao() {
        return notificao;
    }

    public void setNotificao(Notificacao notificao) {
        this.notificao = notificao;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public boolean isEmpty() {
        return nomeDestinatario.equals("")
                || nomeRemetente.equals("")
                || notificao == null
                || texto.equals("")
                || assunto.equals("")
                || port.equals("")
                || host.equals("")
                || destinatario.equals("")
                || remetente.equals("");
    }
}
