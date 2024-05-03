package org.example.municipalcomplaintssystem.db.entities;

import jakarta.persistence.*;

@Table(name = "tipo")
@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id")
    private int id;

    @Column(name = "tip_nome")
    private String nome;

    public Tipo(){
        this(0, "");
    }

    public Tipo(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Tipo(int id){
        this(id, "");
    }

    public Tipo(String nome){
        this(0, nome);
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
