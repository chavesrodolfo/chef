package com.chavesrodolfo.chef.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chavesrodolfo.chef.model.Receita;
import com.chavesrodolfo.chef.service.ReceitaService;

@Controller
@RequestMapping("receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @RequestMapping("/receitas.json")
    public @ResponseBody
    List<Receita> listarReceitas() {
        return receitaService.listarReceitas();
    }
    
    @RequestMapping(value = "/adiciona", method = RequestMethod.POST)
    public @ResponseBody
    void adicionarReceita(@RequestBody Receita receita) {
        receitaService.adicionarReceita(receita);
    }
    
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody 
    void removerReceita(@PathVariable("id") Long id) {
        receitaService.removerReceita(id);
    }
    
    @RequestMapping(value = "/atualiza", method = RequestMethod.PUT)
    public @ResponseBody 
    void atualizarReceita(@RequestBody Receita receita) {
    	receitaService.atualizarReceita(receita);
    }

    @RequestMapping("/layout")
    public String getlayoutReceita() {
        return "receita/layout";
    }
    
}
