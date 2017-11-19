/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Funcionario;
import java.util.List;

/**
 *
 * @author jean
 */
public interface FuncionarioServico {

    List<Funcionario> listAll();

    Funcionario getById(Long id);

    Funcionario getByRg(String rg);

    Funcionario update(Funcionario usuario);

    void delete(Long id);
    
    boolean exist(Long id);
    
    Funcionario save(Funcionario usuario);

    List<Funcionario> findAllByNome(String nome);
    
    
}
