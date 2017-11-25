package com.sistex.cgt;
import com.sistex.cdp.Gerente;
import java.util.List;

public interface GerenteServico {

    List<Gerente> listAll();

    Gerente getById(Long id);

    Gerente getByRg(String rg);

    Gerente update(Gerente gerente);

    void delete(Long id);

    Gerente save(Gerente gerente);

    List<Gerente> findAllByNome(String nome);

    Boolean exist(Long id);
}
