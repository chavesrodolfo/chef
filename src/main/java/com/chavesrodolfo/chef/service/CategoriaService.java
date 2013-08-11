package com.chavesrodolfo.chef.service;

import com.chavesrodolfo.chef.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private static List<Categoria> categorias = new ArrayList<Categoria>();

    static {
        Categoria doces = new Categoria();
        doces.setId(1L);
        doces.setNome("Doces");
        Categoria salgados = new Categoria();
        salgados.setId(2L);
        salgados.setNome("Salgados");
        categorias.add(doces);
        categorias.add(salgados);
    }

    public List<Categoria> listarCategorias() {
        return categorias;
    }

}
