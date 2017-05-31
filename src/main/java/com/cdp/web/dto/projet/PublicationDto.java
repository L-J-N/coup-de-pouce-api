package com.cdp.web.dto.projet;

/**
 * Created by jabuf on 22/02/17.
 */
public class PublicationDto {

    private Long id;

    private Long idProjet;

    private String descriptionLongue;

    private String imageAffichage;

    private String mediaPrincipal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
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
}
