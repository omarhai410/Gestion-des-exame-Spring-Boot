package com.demo.exam;

import javax.persistence.*;

@Entity
public class ElementPedagogique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String niveau;
    @Column(name = "coordonnateur")
    private String coordonnateur; // Champ pour stocker le coordinateur
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getCoordonnateur() {
        return coordonnateur;
    }

    public void setCoordonnateur(String coordonnateur) {
        this.coordonnateur = coordonnateur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromotion() {
        return getPromotion();
    }
}
