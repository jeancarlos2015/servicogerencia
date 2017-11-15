/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jean
 */
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcompra;
    private String nomeproduto;
    private String marcaproduto;
    private String cnpj;
    private Integer quantidade;
    private Float custounidade;

    public Long getIdcompra() {
        return idcompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setIdcompra(Long idcompra) {
        this.idcompra = idcompra;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getMarcaproduto() {
        return marcaproduto;
    }

    public void setMarcaproduto(String marcaproduto) {
        this.marcaproduto = marcaproduto;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Float getCustounidade() {
        return custounidade;
    }

    public void setCustounidade(Float custounidade) {
        this.custounidade = custounidade;
    }
    
    public boolean isEmpty(){
        return cnpj.equals("")||
                custounidade == null ||
                nomeproduto.equals("")||
                marcaproduto.equals("")||
                cnpj.equals("")||
                quantidade==null||
                custounidade==null;
        
    }
}
