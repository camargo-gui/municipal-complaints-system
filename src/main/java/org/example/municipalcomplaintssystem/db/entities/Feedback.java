package org.example.municipalcomplaintssystem.db.entities;

import jakarta.persistence.*;

@Table(name = "feedback")
@Entity
public class Feedback {

    @Id
    @Column(name = "fee_id")
    private int id;

    @Column(name = "fee_texto")
    private String texto;

    @OneToOne
    @JoinColumn(name = "den_id")
    private Denuncia denuncia;

    public Feedback(){
        this(0, "", null);
    }

    public Feedback(int id, String texto, Denuncia denuncia){
        this.id = id;
        this.texto = texto;
        this.denuncia = denuncia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
}
