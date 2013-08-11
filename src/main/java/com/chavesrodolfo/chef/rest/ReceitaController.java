package com.chavesrodolfo.chef.rest;

import com.chavesrodolfo.chef.model.Receita;
import com.chavesrodolfo.chef.model.Tag;
import com.chavesrodolfo.chef.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
