package com.chavesrodolfo.chef.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "RECEITA")
public class Receita implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 25, message = "O nome da receita deve conter entre 3 e 25 caracteres.")
    private String nome;

    @NotNull
    @Size(min = 3, max = 140, message = "O resumo deve conter entre 3 e 140 caracteres.")
    private String resumo;

    @ManyToMany
    @JoinTable(name="RECEITA_TAG",
            joinColumns=
            @JoinColumn(name="ID_RECEITA", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="ID_TAG", referencedColumnName="id")
    )
    private Set<Tag> tags;

    @NotNull
    @Size(min = 3, max = 5000, message = "Os ingredientes devem conter entre 3 e 5000 caracteres.")
    private String ingredientes;

    @NotNull
    @Size(min = 3, max = 5000, message = "O modo de preparo deve conter entre 3 e 5000 caracteres.")
    private String modoPreparo;

    @NotNull
    @Size(min = 3, max = 1000, message = "As observações devem conter entre 3 e 1000 caracteres.")
    private String observacoes;

    private Long notaChef;

    private Byte[] fotoCapa;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "id")
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
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
