/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Gerente;
import java.util.List;

/**
 *
 * @author jean
 */
public interface GerenteServico {

    List<Gerente> listAll();

    Gerente getById(Long id);

    Gerente getByRg(String rg);

    Gerente update(Gerente gerente);

    void delete(Long id);

    Gerente save(Gerente gerente);
    
    List<Gerente> findAllByNome(String nome);
    
    Boolean exist(Long id);
}
