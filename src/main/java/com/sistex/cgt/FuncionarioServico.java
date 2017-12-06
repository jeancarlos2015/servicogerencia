package com.sistex.cgt;
import com.sistex.cdp.Funcionario;
import java.util.List;

public interface FuncionarioServico {

    List<Funcionario> listAll();

    Funcionario getById(Long id);

    Funcionario getByRg(String rg);

    Funcionario update(Funcionario usuario);

    void delete(Long id);

    boolean exist(Long id);
    
    
    boolean exist(String rg);

    Funcionario save(Funcionario usuario);

    List<Funcionario> findAllByNome(String nome);

}
