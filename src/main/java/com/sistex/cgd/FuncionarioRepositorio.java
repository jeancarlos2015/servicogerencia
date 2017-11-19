/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long> {

//    @Modifying
//    @Query("update Funcionario fun set fun.rg = :rg, "
//            + "fun.email = :email,"
//            + "fun.endereco = :endereco,"
//            + "fun.nome = :nome,"
//            + "fun.telefone = :telefone,"
//            + "fun.cargo = :cargo"
//            + " where fun.id = :id")
//    void update(@Param("rg") String rg,
//            @Param("email") String email,
//            @Param("endereco") String endereco,
//            @Param("nome") String nome,
//            @Param("telefone") String telefone,
//            @Param("cargo") String cargo,
//            @Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(fun) > 0 THEN true ELSE false END FROM Funcionario fun WHERE fun.rg = :rg")
    boolean exist(@Param("rg") String rg);

    @Query("SELECT fun FROM Funcionario fun WHERE fun.rg= :rg")
    Funcionario findByRg(@Param("rg") String rg);

    @Query("SELECT fun FROM Funcionario fun WHERE fun.nome like %:nome%")
    List<Funcionario> findAllByNome(@Param("nome") String nome);
}
