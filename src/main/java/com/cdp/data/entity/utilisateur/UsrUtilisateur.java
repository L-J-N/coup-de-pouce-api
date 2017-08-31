package com.cdp.data.entity.utilisateur;


import com.cdp.data.entity.projet.PrProjet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */
@Entity
public class UsrUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createur")
    private List<PrProjet> projets;

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

    public List<PrProjet> getProjets() {
        return projets;
    }

    public void setProjets(List<PrProjet> projets) {
        this.projets = projets;
    }
}
