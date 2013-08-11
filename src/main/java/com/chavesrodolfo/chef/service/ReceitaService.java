package com.chavesrodolfo.chef.service;

import com.chavesrodolfo.chef.model.Categoria;
import com.chavesrodolfo.chef.model.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaService {

    private static List<Receita> receitas = new ArrayList<Receita>();

    @Autowired
    private static CategoriaService categoriaService;

    @Autowired
    private static TagService tagService;

    static {
        Receita receita = new Receita();
        receita.setId(1L);
        receita.setNome("Receita FAKE");

        receita.setCategoria(categoriaService.listarCategorias().get(0));

        receita.setIngredientes("1. lista de ingredientes FAKE");
        receita.setModoPreparo("Modo de preparo FAKE");
        receita.setNotaChef(8L);
        receita.setObservacoes("Observacoe3s FAKE");
        receita.setResumo("Resumo FAKE");
        receita.setTags(tagService.listarTags());

        receitas.add(receita);
    }


}
