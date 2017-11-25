package com.sistex.cgt;

import com.sistex.cdp.Fornecedor;
import java.util.List;

public interface FornecedorServico {

    List<Fornecedor> listAll();

    Fornecedor getById(Long id);

    Fornecedor getByCpf(String cpf);

    Fornecedor save(Fornecedor fornecedor);

    void delete(Long id);

    Fornecedor update(Fornecedor fornecedor);

    List<Fornecedor> findAllByNome(String nome);

    Boolean exist(String cnpj);

    Boolean exist(Long id);
}
