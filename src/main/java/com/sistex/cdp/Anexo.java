package com.sistex.cdp;
import jdk.nashorn.internal.ir.annotations.Ignore;
@Ignore
public class Anexo {

    private String nomeArquivo;
    private String caminho;
    private String descricao;
    private EmailObj email;

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EmailObj getEmail() {
        return email;
    }

    public void setEmail(EmailObj email) {
        this.email = email;
    }

    public boolean isEmpty() {
        return email == null
                || descricao.equals("")
                || caminho.equals("")
                || nomeArquivo.equals("");
    }
}
