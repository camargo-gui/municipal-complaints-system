package org.example.municipalcomplaintssystem.db.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "orgaos")
@Entity
public class Orgao {

    @Id
    @Column(name = "org_id")
    private int id;

    @Column(name = "org_nome")
    private String nome;

    public Orgao(){
        this(0, "");
    }

    public Orgao(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
