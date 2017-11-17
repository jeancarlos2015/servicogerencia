/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface CompraRepositorio extends CrudRepository<Compra, Long>{
    @Query("SELECT co FROM Compra co WHERE co.cnpj like %:cnpj%")
    List<Compra> findAllByCnpj(@Param("cnpj") String cnpj);
   
    
}
