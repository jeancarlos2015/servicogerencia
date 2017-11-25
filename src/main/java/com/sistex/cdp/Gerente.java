package com.sistex.cdp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Gerente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idgerente;
    private String rg;
    private String cargo;

    public Long getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(Long idgerente) {
        this.idgerente = idgerente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean isEmpty() {
        return nome.equals("")
                || telefone.equals("")
                || email.equals("")
                || endereco.equals("")
                || rg.equals("")
                || cargo.equals("");
    }

}
