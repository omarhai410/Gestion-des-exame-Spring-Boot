package com.demo.exam;

import javax.persistence.*;

@Entity
public class GroupeEnseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    // autres attributs selon vos besoins

    // getters and setters
}
