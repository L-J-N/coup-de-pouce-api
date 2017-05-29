package com.cdp.data.entity.projet;


import com.cdp.data.entity.Adresse;
import com.cdp.data.entity.utilisateur.UsrUtilisateur;
import com.cdp.enumeration.TypeProjetEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @NotNull
    @ManyToOne
    private UsrUtilisateur createur;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projet")
    private List<PrStatutProjet> statuts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projet")
    private List<PrPieceJointe> piecesJointes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeProjetEnum typeProjet;

    private String descriptionCourte;

    private Integer sommeDemandee;

    private Integer sommeRecolte;

    private Integer delaiRecolte;

    @OneToOne
    private Adresse adresse;

    @OneToOne(mappedBy = "projet")
    private PrPublication publication;

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

    public List<PrStatutProjet> getStatuts() {
        return statuts;
    }

    public void setStatuts(List<PrStatutProjet> statuts) {
        this.statuts = statuts;
    }

    public List<PrPieceJointe> getPiecesJointes() {
        return piecesJointes;
    }

    public void setPiecesJointes(List<PrPieceJointe> piecesJointes) {
        this.piecesJointes = piecesJointes;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public PrPublication getPublication() {
        return publication;
    }

    public void setPublication(PrPublication publication) {
        this.publication = publication;
    }
}
