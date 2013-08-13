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

    // FIXME INICIO MOCK
    static {
        Receita receita = new Receita();
        receita.setId(1L);
        receita.setNome("Macarrão à carbonara");

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Doces");
        receita.setCategoria(categoria);

        receita.setIngredientes("bacon picado a gosto\n" +
                "queijo ralado a gosto\n" +
                "3 ovos\n" +
                "sal, pimenta\n" +
                "marrarrão de sua escolha, espaguete, fusili..\n" +
                "creme de leite se quiser dar um toque diferente à receita");
        receita.setModoPreparo("\n" +
                "Fritar bem o bacon, até ficar crocante\n" +
                "Pode-se adicionar salame picado\n" +
                "Colocar o macarrão à cozinhar em água e sal\n" +
                "no refratário onde será servido o macarrão, bater bem os ovos com um garfo os ovos crus, temperar com sal e pimenta à gosto, e juntar o queijo ralado, também a gosto\n" +
                "Quando o macarrão estiver pronto, escorrer e colocar, bem quente, sobre a mistura de ovos, e misturar bem\n" +
                "O calor da massa cozinha os ovos\n" +
                "Colocar o molho de bacon e creme de leite, ainda quente, sobre o macarrão e servir");
        receita.setNotaChef(8L);
        receita.setObservacoes("Observacoes FAKE");
        receita.setResumo("O molho a carbonara os ovos vão batido com um garfo junto com parmesão e se quiser um poco de creme de leite e colocar quando a massa está cozida,juntando" +
                " o bacon frito com azeite mexer tudo ate ficar o molho bem encorpado. E buon appetito.");

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
    // FIXME FIM MOCK

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
