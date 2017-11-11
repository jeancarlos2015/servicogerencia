/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface FornecedorRepositorio extends CrudRepository<Fornecedor, Long>{
    @Modifying
    @Query("update Fornecedor fo set fo.cnpj = :cnpj, "
            + "fo.email = :email,"
            + "fo.endereco = :endereco,"
            + "fo.nome = :nome,"
            + "fo.telefone = :telefone"
            + " where fo.id = :id")
    void update(@Param("cnpj") String cnpj,
            @Param("email") String email,
            @Param("endereco") String endereco,
            @Param("nome") String nome,
            @Param("telefone") String telefone,
            @Param("id") Long id);
    
    @Query("SELECT CASE WHEN COUNT(fo) > 0 THEN true ELSE false END FROM Fornecedor fo WHERE fo.cnpj = :cnpj")
    boolean exist(@Param("cnpj") String cnpj);
    
  
    @Query("SELECT fo FROM Fornecedor fo WHERE fo.cnpj= :cnpj")
    Fornecedor findByCpf(@Param("cnpj") String cnpj);
    
    @Query("SELECT fo FROM Fornecedor fo WHERE fo.nome like %:nome%")
    List<Fornecedor> findAllByNome(@Param("nome") String nome);
    
}
