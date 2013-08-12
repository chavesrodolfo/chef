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
        receita.setObservacoes("Observacoes FAKE");
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
    
    public void adicionarReceita(Receita receita) {
    	receitas.add(receita);
    }

	public void removerReceita(Long id) {
		Receita receita = buscarReceita(id);
        if (receita != null) {
            receitas.remove(receita);
        }
	}
	
	public void atualizarReceita(Receita receita) {
		Receita receitaLocalizada = buscarReceita(receita.getId());
		if (receitaLocalizada != null) {
			receitas.remove(receitaLocalizada);
			receitas.add(receita);
		}
	}
	
	private Receita buscarReceita(Long id) {
		for (Receita receita : receitas) {
			if (receita.getId() == id) {
				return receita;
			}
		}
		return null;
	}

}
