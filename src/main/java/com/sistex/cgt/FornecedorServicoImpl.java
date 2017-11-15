/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Fornecedor;
import com.sistex.cgd.FornecedorRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.FORNECEDOR;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class FornecedorServicoImpl implements FornecedorServico{
    private final Fabrica fabrica = Fabrica.make(FORNECEDOR);
    @Autowired
    private  FornecedorRepositorio fornecedorRepositorio;
    
    @Override
    public List<Fornecedor> listAll() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        fornecedorRepositorio.findAll().forEach(fornecedores::add); //fun with Java 8
        return fornecedores;
    }

    @Override
    public Fornecedor getById(Long id) {
        return fornecedorRepositorio.findOne(id);
    }

    @Override
    public Fornecedor getByCpf(String cpf) {
        return fornecedorRepositorio.findByCpf(cpf);
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        if(!fornecedorRepositorio.exist(fornecedor.getCnpj()) && !fornecedor.isEmpty()){
            return fornecedorRepositorio.save(fornecedor);
        }
        return fabrica.criaFornecedor();
    }

    @Override
    public void delete(Long id) {
        if(fornecedorRepositorio.exists(id)){
            fornecedorRepositorio.delete(id);
        }
    }

    @Override
    public Fornecedor update(Fornecedor fornecedor) {
        if(fornecedorRepositorio.exist(fornecedor.getCnpj()) && !fornecedor.isEmpty()){
            fornecedorRepositorio.update(fornecedor.getCnpj(),
                                fornecedor.getEmail(),
                                fornecedor.getEndereco(), 
                                fornecedor.getNome(), 
                                fornecedor.getTelefone(),
                                fornecedor.getIdfornecedor());
        }
        return fabrica.criaFornecedor();
    }


    @Override
    public List<Fornecedor> findAllByNome(String nome) {
        return fornecedorRepositorio.findAllByNome(nome);
    }
    
}
