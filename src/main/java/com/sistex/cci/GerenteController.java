/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Gerente;
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
import com.sistex.cgt.GerenteServico;

/**
 *
 * @author jean
 */
@Controller
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    private GerenteServico gerenteService;

   
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean excluir(@PathVariable("id") Long id) {
        gerenteService.delete(id);
        return !gerenteService.exist(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean cadastrar(@RequestBody Gerente gerente) {
        Gerente novo = gerenteService.save(gerente);
        return gerenteService.exist(novo.getIdgerente());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Gerente alterar(@PathVariable("id") Long id, @RequestBody Gerente gerente) {
        gerente.setIdgerente(id);
        return gerenteService.update(gerente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Gerente buscarGerente(@PathVariable("id") String id) {
        return gerenteService.getById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Gerente> listGerentes() {
        return gerenteService.listAll();
    }
    
    @RequestMapping(value = "/listar/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public List<Gerente> listGerentesNome(@PathVariable("nome") String nome) {
        return gerenteService.findAllByNome(nome);
    }
}
