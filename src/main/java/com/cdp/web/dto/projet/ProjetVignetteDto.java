package com.cdp.web.dto.projet;

import com.cdp.enumeration.StatutProjetEnum;

import java.util.Date;

/**
 * Created by jabuf on 22/02/17.
 */
public class ProjetVignetteDto {

    private Long idProjet;

    private String nom;

    private String descriptionCourte;

    private StatutProjetEnum statut;

    private Integer sommeDemandee;

    private Integer sommeRecolte;

    private Integer delaiRecolte;

    private Date dateDebutPublication;

    private String imageAffichage;

    public Long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptionCourte() {
        return descriptionCourte;
    }

    public void setDescriptionCourte(String descriptionCourte) {
        this.descriptionCourte = descriptionCourte;
    }

    public StatutProjetEnum getStatut() {
        return statut;
    }

    public void setStatut(StatutProjetEnum statut) {
        this.statut = statut;
    }

    public Integer getSommeDemandee() {
        return sommeDemandee;
    }

    public void setSommeDemandee(Integer sommeDemandee) {
        this.sommeDemandee = sommeDemandee;
    }

    public Integer getSommeRecolte() {
        return sommeRecolte;
    }

    public void setSommeRecolte(Integer sommeRecolte) {
        this.sommeRecolte = sommeRecolte;
    }

    public Integer getDelaiRecolte() {
        return delaiRecolte;
    }

    public void setDelaiRecolte(Integer delaiRecolte) {
        this.delaiRecolte = delaiRecolte;
    }

    public Date getDateDebutPublication() {
        return dateDebutPublication;
    }

    public void setDateDebutPublication(Date dateDebutPublication) {
        this.dateDebutPublication = dateDebutPublication;
    }

    public String getImageAffichage() {
        return imageAffichage;
    }

    public void setImageAffichage(String imageAffichage) {
        this.imageAffichage = imageAffichage;
    }
}
