/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Notificacao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface NotificacaoRepositorio extends CrudRepository<Notificacao, Long>{
    @Query("SELECT no FROM Notificacao no WHERE no.email like %:email%")
    List<Notificacao> findAllByEmail(@Param("email") String email);
}
