/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Funcionario;
import com.sistex.cgd.FuncionarioRepositorio;
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
public class FuncionarioServicoImpl implements FuncionarioServico {

    private final Fabrica fabrica = Fabrica.make(FORNECEDOR);
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Override
    public List<Funcionario> listAll() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarioRepositorio.findAll().forEach(funcionarios::add); //fun with Java 8
        return funcionarios;
    }

    @Override
    public Funcionario getById(Long id) {
        return funcionarioRepositorio.findOne(id);
    }

    @Override
    public Funcionario getByRg(String rg) {
        return funcionarioRepositorio.findByRg(rg);
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        if (!funcionarioRepositorio.exist(funcionario.getRg()) && !funcionario.isEmpty()) {
            return funcionarioRepositorio.save(funcionario);
        }
        return fabrica.criaFuncionario();
    }

    @Override
    public void delete(Long id) {
        if (funcionarioRepositorio.exists(id)) {
            funcionarioRepositorio.delete(id);
        }
    }

    @Override
    public Funcionario update(Funcionario funcionario) {
        if (funcionarioRepositorio.exist(funcionario.getRg()) && !funcionario.isEmpty()) {
            return funcionarioRepositorio.save(funcionario);
        }
        return fabrica.criaFuncionario();
    }

  

    @Override
    public List<Funcionario> findAllByNome(String nome) {
        return funcionarioRepositorio.findAllByNome(nome);
    }

    @Override
    public boolean exist(Long id) {
        return funcionarioRepositorio.exists(id);
    }

}
