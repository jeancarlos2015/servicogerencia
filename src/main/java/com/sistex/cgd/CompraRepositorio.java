package com.sistex.cgd;
import com.sistex.cdp.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompraRepositorio extends CrudRepository<Compra, Long> {

    @Query("SELECT co FROM Compra co WHERE co.cnpj like %:cnpj%")
    List<Compra> findAllByCnpj(@Param("cnpj") String cnpj);

}
