package org.example.municipalcomplaintssystem.db.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "denuncia")
@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "den_id")
    private int id;

    @Column(name = "den_titulo")
    private String titulo;

    @Column(name = "den_texto")
    private String texto;

    @Column(name = "den_urgencia")
    private int urgencia;

    @Column(name = "den_data")
    private Timestamp data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    private Orgao orgao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tip_id")
    private Tipo tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usu_id")
    private Usuario usuario;

    public Denuncia(){
        this(0, "", "", 0, null, null, null);
    }

    public Denuncia(int id, String titulo, String texto, int urgencia, Orgao orgao, Tipo tipo, Usuario usuario){
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.urgencia = urgencia;
        this.orgao = orgao;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
