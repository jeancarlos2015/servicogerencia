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
    private Long idcompra=1L;
    private String nomeProduto;
    private String marca;
    private Integer qtcompras=0;
    private String cnpjFornecedor;
    private float total_compra=0;
    public Long getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Long idcompra) {
        this.idcompra = idcompra;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getQtcompras() {
        return qtcompras;
    }

    public void setQtcompras(Integer qtcompras) {
        this.qtcompras = qtcompras;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public float getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(float total_compra) {
        this.total_compra = total_compra;
    }
}
