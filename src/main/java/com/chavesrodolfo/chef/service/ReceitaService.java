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
    private static final int CARACTERES_RESUMO = 140;

    // FIXME INICIO MOCK -----------------------------------------------------------------------------------------------
    static {
        for (long i=1; i<5; i++){
            Receita receita = new Receita();
            receita.setId(i);
            receita.setNome("Macarrão à carbonara");

            Categoria categoria = new Categoria();
            categoria.setId(i);
            categoria.setNome("Salgados");
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
                    "no refratário onde será servido o macarrão, bater bem os ovos com um garfo os ovos crus, " +
                    "temperar com sal e pimenta à gosto, e juntar o queijo ralado, também a gosto\n" +
                    "Quando o macarrão estiver pronto, escorrer e colocar, bem quente, sobre a mistura de ovos, e misturar bem\n" +
                    "O calor da massa cozinha os ovos\n" +
                    "Colocar o molho de bacon e creme de leite, ainda quente, sobre o macarrão e servir");
            receita.setNotaChef(8L);
            receita.setObservacoes("Observacoes FAKE");
            receita.setResumo(sintetizarString("O molho a carbonara os ovos vão batido com um garfo junto com parmesão " +
                    "e se quiser um poco de creme de leite e colocar quando a massa está cozida,juntando" +
                    " o bacon frito com azeite mexer tudo ate ficar o molho bem encorpado. E buon appetito.", CARACTERES_RESUMO));

            Tag tagA = new Tag();
            tagA.setId(i);
            tagA.setNome("macarronada");
            Tag tagB = new Tag();
            tagB.setId(i+1);
            tagB.setNome("molho branco");
            List<Tag> tags = new ArrayList<Tag>();
            tags.add(tagA);
            tags.add(tagB);
            receita.setTags(tags);

            receitas.add(receita);
        }
    }
    // FIXME FIM MOCK  -------------------------------------------------------------------------------------------------

    private static String sintetizarString(String str, int caracteres){
        return str.substring(0,caracteres).concat("...");
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
