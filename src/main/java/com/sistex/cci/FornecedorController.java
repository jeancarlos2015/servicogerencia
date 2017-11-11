/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Fornecedor;
import com.sistex.cgt.FornecedorServico;
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
@RequestMapping("/fornecedor")
public class FornecedorController {
    private FornecedorServico fornecedorService;

   
    @Autowired
    public void setFornecedorService(FornecedorServico fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        fornecedorService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Fornecedor cadastrar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Fornecedor alterar(@PathVariable("id") Long id, @RequestBody Fornecedor fornecedor) {
        fornecedor.setIdfornecedor(id);
        return fornecedorService.update(fornecedor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Fornecedor buscarFornecedor(@PathVariable("id") String id) {
        return fornecedorService.getById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Fornecedor> listFornecedors() {
        return fornecedorService.listAll();
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
    @ResponseBody
    public List<Fornecedor> listFornecedoresNome(@PathVariable("nome") String nome) {
        return fornecedorService.findAllByNome(nome);
    }
}
