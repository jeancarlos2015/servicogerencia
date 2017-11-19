/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Funcionario;
import com.sistex.cgt.FuncionarioServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jean
 */
@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioServico funcionarioService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean excluir(@PathVariable("id") Long id) {
        funcionarioService.delete(id);
        return !funcionarioService.exist(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean cadastrar(@RequestBody Funcionario funcionario) {
        Funcionario novo = funcionarioService.save(funcionario);
        return funcionarioService.exist(novo.getIdfuncionario());
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Funcionario alterar(@RequestBody Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Funcionario buscarFuncionario(@PathVariable("id") String id) {
        return funcionarioService.getById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Funcionario> listFuncionarios() {
        return funcionarioService.listAll();
    }

    @RequestMapping(value = "/listar/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public List<Funcionario> listFuncionariosNome(@PathVariable("nome") String nome) {
        return funcionarioService.findAllByNome(nome);
    }
}