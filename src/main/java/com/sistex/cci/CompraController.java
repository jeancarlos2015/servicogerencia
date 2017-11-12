/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Compra;
import com.sistex.cgt.CompraServico;
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
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraServico compraServico;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        compraServico.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Compra cadastrar(@RequestBody Compra compra) {
        return compraServico.save(compra);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Compra alterar(@PathVariable("id") Long id, @RequestBody Compra compra) {
        compra.setIdcompra(id);
        return compraServico.update(compra);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Compra buscarCompra(@PathVariable("id") String id) {
        return compraServico.getById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Compra> listCompras() {
        return compraServico.listAll();
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
    @ResponseBody
    public List<Compra> listCompraesNome(@PathVariable("nome") String nome) {
        return compraServico.findAllByCnpj(nome);
    }
}
