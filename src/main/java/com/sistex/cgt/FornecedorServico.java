/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Fornecedor;
import java.util.List;

/**
 *
 * @author jean
 */
public interface FornecedorServico {
    List<Fornecedor> listAll();

    Fornecedor getById(Long id);
    
    Fornecedor getByCpf(String cpf);
    
    Fornecedor save(Fornecedor fornecedor);

    void delete(Long id);

    Fornecedor update(Fornecedor fornecedor);
    
    List<Fornecedor> findAllByNome(String nome);
}
