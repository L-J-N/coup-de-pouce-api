package com.cdp.data.entity.projet;


import com.cdp.data.entity.utilisateur.UsrUtilisateur;
import com.cdp.enumeration.TypeProjetEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jabuf on 22/02/17.
 */
@Entity
public class PrProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nom;

    @ManyToOne
    private UsrUtilisateur createur;

    @NotNull
    private TypeProjetEnum typeProjet;

    private String descriptionCourte;

    private Integer sommeDemandee;

    private Integer delaiRecolte;

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

    public UsrUtilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(UsrUtilisateur createur) {
        this.createur = createur;
    }

    public TypeProjetEnum getTypeProjet() {
        return typeProjet;
    }

    public void setTypeProjet(TypeProjetEnum typeProjet) {
        this.typeProjet = typeProjet;
    }

    public String getDescriptionCourte() {
        return descriptionCourte;
    }

    public void setDescriptionCourte(String descriptionCourte) {
        this.descriptionCourte = descriptionCourte;
    }

    public Integer getSommeDemandee() {
        return sommeDemandee;
    }

    public void setSommeDemandee(Integer sommeDemandee) {
        this.sommeDemandee = sommeDemandee;
    }

    public Integer getDelaiRecolte() {
        return delaiRecolte;
    }

    public void setDelaiRecolte(Integer delaiRecolte) {
        this.delaiRecolte = delaiRecolte;
    }
}
