package com.cdp.data.entity.projet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jabuf on 23/02/17.
 */
@Entity
public class PrPublication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private PrProjet projet;

    @Column(columnDefinition="TEXT")
    private String descriptionLongue;

    private String imageAffichage;

    private String mediaPrincipal;

    @NotNull
    private int nombreVisites = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrProjet getProjet() {
        return projet;
    }

    public void setProjet(PrProjet projet) {
        this.projet = projet;
    }

    public String getDescriptionLongue() {
        return descriptionLongue;
    }

    public void setDescriptionLongue(String descriptionLongue) {
        this.descriptionLongue = descriptionLongue;
    }

    public String getImageAffichage() {
        return imageAffichage;
    }

    public void setImageAffichage(String imageAffichage) {
        this.imageAffichage = imageAffichage;
    }

    public String getMediaPrincipal() {
        return mediaPrincipal;
    }

    public void setMediaPrincipal(String mediaPrincipal) {
        this.mediaPrincipal = mediaPrincipal;
    }

    public int getNombreVisites() {
        return nombreVisites;
    }

    public void setNombreVisites(int nombreVisites) {
        this.nombreVisites = nombreVisites;
    }
}
