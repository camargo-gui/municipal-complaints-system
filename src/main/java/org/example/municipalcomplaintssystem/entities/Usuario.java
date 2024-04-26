package org.example.municipalcomplaintssystem.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "usu_id"
    )
    private int id;

    @Column(
            name = "usu_cpf"
    )
    private String cpf;

    @Column(
            name = "usu_email"
    )
    private String email;

    @Column(
            name = "usu_senha"
    )
    private String senha;

    @Column(
            name = "usu_nivel"
    )
    private String nivel;

}
