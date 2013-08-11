package com.chavesrodolfo.chef.service;

import com.chavesrodolfo.chef.model.Categoria;
import com.chavesrodolfo.chef.model.Receita;
import com.chavesrodolfo.chef.model.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaService {

    private static List<Receita> receitas = new ArrayList<Receita>();

    static {
        Receita receita = new Receita();
        receita.setId(1L);
        receita.setNome("Receita FAKE");

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Doces");
        receita.setCategoria(categoria);

        receita.setIngredientes("1. lista de ingredientes FAKE");
        receita.setModoPreparo("Modo de preparo FAKE");
        receita.setNotaChef(8L);
        receita.setObservacoes("Observacoe3s FAKE");
        receita.setResumo("Resumo FAKE");

        Tag tagA = new Tag();
        tagA.setId(1L);
        tagA.setNome("TAG A");
        Tag tagB = new Tag();
        tagB.setId(1L);
        tagB.setNome("TAG B");
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tagA);
        tags.add(tagB);
        receita.setTags(tags);

        receitas.add(receita);
    }

    public List<Receita> listarReceitas(){
        return receitas;
    }

}
