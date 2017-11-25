package com.sistex.cdp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfornecedor;

    private String cnpj;

    public Long getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Long idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean isEmpty() {
        return nome.equals("")
                || telefone.equals("")
                || email.equals("")
                || endereco.equals("")
                || cnpj.equals("");
    }

}
