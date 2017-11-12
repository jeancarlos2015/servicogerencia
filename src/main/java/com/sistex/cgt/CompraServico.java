/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Compra;
import java.util.List;

/**
 *
 * @author jean
 */
public interface CompraServico {
    List<Compra> listAll();

    Compra getById(Long id);

    Compra update(Compra compra);

    void delete(Long id);

    Compra save(Compra compra);
    
    List<Compra> findAllByCnpj(String nome);
}
