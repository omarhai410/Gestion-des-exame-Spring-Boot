package com.demo.exam;

import javax.persistence.*;

@Entity
@Table(name = "groupe")
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "enseignants")
    private String enseignants; // Peut-être une chaîne JSON ou une liste d'enseignants

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(String enseignants) {
        this.enseignants = enseignants;
    }
}
