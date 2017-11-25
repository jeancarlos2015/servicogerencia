package com.sistex.cgd;
import com.sistex.cdp.Notificacao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotificacaoRepositorio extends CrudRepository<Notificacao, Long> {

    @Query("SELECT no FROM Notificacao no WHERE no.email like %:email%")
    List<Notificacao> findAllByEmail(@Param("email") String email);
}
