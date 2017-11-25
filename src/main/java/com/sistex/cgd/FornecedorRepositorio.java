package com.sistex.cgd;
import com.sistex.cdp.Fornecedor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FornecedorRepositorio extends CrudRepository<Fornecedor, Long> {

    @Query("SELECT CASE WHEN COUNT(fo) > 0 THEN true ELSE false END FROM Fornecedor fo WHERE fo.cnpj = :cnpj")
    boolean exist(@Param("cnpj") String cnpj);

    @Query("SELECT fo FROM Fornecedor fo WHERE fo.cnpj= :cnpj")
    Fornecedor findByCpf(@Param("cnpj") String cnpj);

    @Query("SELECT fo FROM Fornecedor fo WHERE fo.nome like %:nome%")
    List<Fornecedor> findAllByNome(@Param("nome") String nome);

}
