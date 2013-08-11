package com.chavesrodolfo.chef.model;

import java.util.List;

public class Receita {

    private Long id;
    private String nome;
    private String resumo;
    private List<Tag> tags;
    private String ingredientes;
    private String modoPreparo;
    private String observacoes;
    private Long notaChef;
    private Byte[] fotoCapa;
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getNotaChef() {
        return notaChef;
    }

    public void setNotaChef(Long notaChef) {
        this.notaChef = notaChef;
    }

    public Byte[] getFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(Byte[] fotoCapa) {
        this.fotoCapa = fotoCapa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
