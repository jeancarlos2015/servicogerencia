package com.sistex.cgt;
import com.sistex.cgd.NotificacaoRepositorio;
import static com.sistex.util.Tipo.DB;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificacaoDB extends NotificacaoChain {

    @Autowired
    private NotificacaoRepositorio notificacaoRepositorio;

    public NotificacaoDB() {
        super(DB);
    }

    @Override
    public void enviar() {
        notificacaoRepositorio.save(email.getNotificao());
    }

}
