package com.sistex.cgt;

import com.sistex.cdp.Gerente;
import com.sistex.util.Fabrica;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistex.cgd.GerenteRepositorio;
import static com.sistex.util.Tipo.GERENTE;

@Service
public class GerenteServicoImpl implements GerenteServico {

    private final Fabrica fabrica = Fabrica.make(GERENTE);
    @Autowired
    private GerenteRepositorio gerenteRepositorio;

    @Override
    public List<Gerente> listAll() {
        List<Gerente> gerentes = new ArrayList<>();
        gerenteRepositorio.findAll().forEach(gerentes::add); //fun with Java 8
        return gerentes;
    }

    @Override
    public Gerente getById(Long id) {
        return gerenteRepositorio.findOne(id);
    }

    @Override
    public Gerente getByRg(String rg) {
        return gerenteRepositorio.findByRg(rg);
    }

    @Override
    public Gerente save(Gerente gerente) {
        if (!gerenteRepositorio.exist(gerente.getRg()) && !gerente.isEmpty()) {
            return gerenteRepositorio.save(gerente);
        }
        return fabrica.criaGerente();
    }

    @Override
    public void delete(Long id) {
        if (gerenteRepositorio.exists(id)) {
            gerenteRepositorio.delete(id);
        }
    }

    @Override
    public Gerente update(Gerente gerente) {
        if (gerenteRepositorio.exist(gerente.getRg()) && !gerente.isEmpty()) {
            return gerenteRepositorio.save(gerente);
        }
        return fabrica.criaGerente();
    }

    @Override
    public List<Gerente> findAllByNome(String nome) {
        return gerenteRepositorio.findAllByNome(nome);
    }

    @Override
    public Boolean exist(Long id) {
        return gerenteRepositorio.exists(id);
    }

}
