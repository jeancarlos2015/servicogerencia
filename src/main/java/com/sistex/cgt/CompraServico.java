package com.sistex.cgt;

import com.sistex.cdp.Compra;
import java.util.List;

/**
 *
 * @author jean
 */
public interface CompraServico {

    List<Compra> listAll();

    Compra getById(Long id);

    Compra update(Compra compra);

    void delete(Long id);

    Compra save(Compra compra);

    List<Compra> findAllByCnpj(String nome);

    boolean exist(Long id);
}
