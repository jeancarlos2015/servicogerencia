package com.sistex.cgt;

import com.sistex.cdp.Fornecedor;
import com.sistex.cgd.FornecedorRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.FORNECEDOR;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorServicoImpl implements FornecedorServico {

    private final Fabrica fabrica = Fabrica.make(FORNECEDOR);
    @Autowired
    private FornecedorRepositorio fornecedorRepositorio;

    @Override
    public List<Fornecedor> listAll() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        fornecedorRepositorio.findAll().forEach(fornecedores::add); //fun with Java 8
        return fornecedores;
    }

    @Override
    public Fornecedor getById(Long id) {
        return fornecedorRepositorio.findOne(id);
    }

    @Override
    public Fornecedor getByCpf(String cpf) {
        return fornecedorRepositorio.findByCpf(cpf);
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        if (!fornecedorRepositorio.exist(fornecedor.getCnpj()) && !fornecedor.isEmpty()) {
            return fornecedorRepositorio.save(fornecedor);
        }
        return fabrica.criaFornecedor();
    }

    @Override
    public void delete(Long id) {
        if (fornecedorRepositorio.exists(id)) {
            fornecedorRepositorio.delete(id);
        }
    }

    @Override
    public Fornecedor update(Fornecedor fornecedor) {
        if (fornecedorRepositorio.exist(fornecedor.getCnpj())) {
            return fornecedorRepositorio.save(fornecedor);
        }
        return fabrica.criaFornecedor();
    }

    @Override
    public List<Fornecedor> findAllByNome(String nome) {
        return fornecedorRepositorio.findAllByNome(nome);
    }

    @Override
    public Boolean exist(String cnpj) {
        return fornecedorRepositorio.exist(cnpj);
    }

    @Override
    public Boolean exist(Long id) {
        return fornecedorRepositorio.exists(id);
    }

}
