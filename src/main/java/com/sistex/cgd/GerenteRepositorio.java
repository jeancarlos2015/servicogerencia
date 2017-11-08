/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;


import com.sistex.cdp.Gerente;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface GerenteRepositorio extends CrudRepository<Gerente, Long>{
    @Modifying
    @Query("update Gerente gerente set gerente.rg = :rg, "
            + "gerente.email = :email,"
            + "gerente.endereco = :endereco,"
            + "gerente.nome = :nome,"
            + "gerente.telefone = :telefone,"
            + "gerente.cargo = :cargo"
            + " where gerente.id = :id")
    void update(@Param("rg") String rg,
            @Param("email") String email,
            @Param("endereco") String endereco,
            @Param("nome") String nome,
            @Param("telefone") String telefone,
            @Param("cargo") String cargo,
            @Param("id") Long id);
    
    @Query("SELECT CASE WHEN COUNT(gerente) > 0 THEN true ELSE false END FROM Gerente gerente WHERE gerente.rg = :rg")
    boolean exist(@Param("rg") String rg);
    
  
    @Query("SELECT gerente FROM Gerente gerente WHERE gerente.rg= :rg")
    Gerente findByRg(@Param("rg") String rg);
    
    @Query("SELECT gerente FROM Gerente gerente WHERE gerente.nome like %:nome%")
    List<Gerente> findAllByNome(@Param("nome") String nome);
}
