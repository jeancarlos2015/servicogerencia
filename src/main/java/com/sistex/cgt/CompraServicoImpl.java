/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Compra;
import com.sistex.cgd.CompraRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class CompraServicoImpl implements CompraServico{
    @Autowired
    private CompraRepositorio compraRepositorio;
    @Override
    public List<Compra> listAll() {
        List<Compra> compras = new ArrayList<>();
        compraRepositorio.findAll().forEach(compras::add);
        return compras;
    }

    @Override
    public Compra getById(Long id) {
        return compraRepositorio.findOne(id);
    }

    @Override
    public Compra update(Compra compra) {
        compraRepositorio.update(compra.getCnpj(), 
                                 compra.getNomeproduto(), 
                                 compra.getQuantidade(), 
                                 compra.getMarcaproduto(), 
                                 compra.getCustounidade(),
                                 compra.getIdcompra());
        return compraRepositorio.findOne(compra.getIdcompra());
    }

    @Override
    public void delete(Long id) {
        if(compraRepositorio.exists(id)){
           compraRepositorio.delete(id);
        }
    }

    @Override
    public Compra save(Compra compra) {
        return compraRepositorio.save(compra);
    }

    @Override
    public List<Compra> findAllByCnpj(String cnpj) {
        return compraRepositorio.findAllByCnpj(cnpj);
    }
    
}
