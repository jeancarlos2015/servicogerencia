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
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfuncionario;
    private String rg="";
    private String cargo="";
    

    /**
     *
     * @return
     */
    public Long getIdfuncionario() {
        return idfuncionario;
    }

    /**
     *
     * @param idfuncionario
     */
    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    /**
     *
     * @return
     */
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     *
     * @return
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public boolean isEmpty(){
        return nome.equals("") || 
                telefone.equals("") ||
                email.equals("") ||
                endereco.equals("") ||
                datanascimento.equals("") ||
                rg.equals("") ||
                cargo.equals("");
    }

}
