package com.sistex.cgd;

import com.sistex.cdp.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long> {

    @Query("SELECT CASE WHEN COUNT(fun) > 0 THEN true ELSE false END FROM Funcionario fun WHERE fun.rg = :rg")
    boolean exist(@Param("rg") String rg);

    @Query("SELECT fun FROM Funcionario fun WHERE fun.rg= :rg")
    Funcionario findByRg(@Param("rg") String rg);

    @Query("SELECT fun FROM Funcionario fun WHERE fun.nome like %:nome%")
    List<Funcionario> findAllByNome(@Param("nome") String nome);
}
