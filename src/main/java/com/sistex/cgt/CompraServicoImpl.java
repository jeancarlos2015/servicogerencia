package com.sistex.cgt;
import com.sistex.cdp.Compra;
import com.sistex.cgd.CompraRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.COMPRA;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServicoImpl implements CompraServico {

    @Autowired
    private CompraRepositorio compraRepositorio;

    private Fabrica fabrica = Fabrica.make(COMPRA);

    @Override
    public List<Compra> listAll() {
        List<Compra> compras = new ArrayList<>();
        compraRepositorio.findAll().forEach(compras::add);
        return compras;
    }

    @Override
    public Compra getById(Long id) {
        return compraRepositorio.findOne(id);
    }

    @Override
    public Compra update(Compra compra) {
        if (exist(compra.getIdcompra())) {
            return compraRepositorio.save(compra);
        }
        return fabrica.criaCompra();
    }

    @Override
    public void delete(Long id) {
        if (compraRepositorio.exists(id)) {
            compraRepositorio.delete(id);
        }
    }

    @Override
    public Compra save(Compra compra) {
        if (!compra.isEmpty()) {
            return compraRepositorio.save(compra);
        }
        return fabrica.criaCompra();
    }

    @Override
    public List<Compra> findAllByCnpj(String cnpj) {
        return compraRepositorio.findAllByCnpj(cnpj);
    }

    @Override
    public boolean exist(Long id) {
        return compraRepositorio.exists(id);
    }

}
