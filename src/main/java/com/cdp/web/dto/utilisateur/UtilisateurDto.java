package com.cdp.web.dto.utilisateur;

/**
 * Created by jabuf on 22/02/17.
 */
public class UtilisateurDto {

    private Long id;

    private String nom;

    private String prenom;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
