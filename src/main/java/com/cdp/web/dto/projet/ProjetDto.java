package com.cdp.web.dto.projet;

import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.enumeration.TypeProjetEnum;
import com.cdp.web.dto.AdresseDto;
import com.cdp.web.dto.utilisateur.UtilisateurDto;

import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */
public class ProjetDto {

    private Long id;

    private String nom;

    private UtilisateurDto createur;

    private PrStatutProjet statut;

    private List<String> urlsPiecesJointes;

    private TypeProjetEnum typeProjet;

    private String descriptionCourte;

    private Integer sommeDemandee;

    private Integer sommeRecolte;

    private Integer delaiRecolte;

    private AdresseDto adresse;

    private String commentaire;

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

    public UtilisateurDto getCreateur() {
        return createur;
    }

    public void setCreateur(UtilisateurDto createur) {
        this.createur = createur;
    }

    public PrStatutProjet getStatut() {
        return statut;
    }

    public void setStatut(PrStatutProjet statut) {
        this.statut = statut;
    }

    public List<String> getUrlsPiecesJointes() {
        return urlsPiecesJointes;
    }

    public void setUrlsPiecesJointes(List<String> urlsPiecesJointes) {
        this.urlsPiecesJointes = urlsPiecesJointes;
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

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
