package com.chavesrodolfo.chef.rest;

import com.chavesrodolfo.chef.model.Categoria;
import com.chavesrodolfo.chef.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("categorias.json")
    public @ResponseBody
    List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

}
