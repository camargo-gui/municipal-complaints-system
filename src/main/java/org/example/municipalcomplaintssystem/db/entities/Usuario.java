package org.example.municipalcomplaintssystem.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private int id;

    @Column(name = "usu_cpf")
    private String cpf;

    @Column(name = "usu_email")
    private String email;

    @Column(name = "usu_senha")
    private String senha;

    @Column(name = "usu_nivel")
    private int nivel;

    public Usuario() {
        this(0, "", "", "", 0);
    }

    public Usuario(int i, String s, String s1, String s2, int s3) {
        this.id = i;
        this.cpf = s;
        this.email = s1;
        this.senha = s2;
        this.nivel = s3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
