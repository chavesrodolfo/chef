package com.chavesrodolfo.chef.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@SuppressWarnings("serial")
@Entity
@Table(name = "CATEGORIA", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 25, message = "O nome deve conter entre 1 e 25 caracteres.")
    @Pattern(regexp = "[^0-9]*", message = "O nome da categoria não deve conter números.")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
