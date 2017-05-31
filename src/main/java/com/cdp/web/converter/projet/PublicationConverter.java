package com.cdp.web.converter.projet;


import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrPublication;
import com.cdp.service.projet.ProjetService;
import com.cdp.web.dto.projet.PublicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class PublicationConverter {

    @Autowired
    private ProjetService projetService;

    public PublicationDto toDto(final PrPublication publication) {

        PublicationDto publicationDto = null;

        if (publication != null) {

            publicationDto = new PublicationDto();
            publicationDto.setId(publication.getId());
            publicationDto.setIdProjet(publication.getProjet().getId());
            publicationDto.setDescriptionLongue(publication.getDescriptionLongue());
            publicationDto.setImageAffichage(publication.getImageAffichage());
            publicationDto.setMediaPrincipal(publication.getMediaPrincipal());
        }

        return publicationDto;
    }

    public PrPublication toEntity(final PublicationDto publicationDto) {

        PrPublication publication = null;

        if (publicationDto != null && publicationDto.getIdProjet() != null) {

            PrProjet projet = projetService.getById(publicationDto.getIdProjet());

            if (projet != null) {

                publication = new PrPublication();

                publication.setId(publicationDto.getId());
                publication.setProjet(projet);
                publication.setDescriptionLongue(publicationDto.getDescriptionLongue());
                publication.setImageAffichage(publicationDto.getImageAffichage());
                publication.setMediaPrincipal(publicationDto.getMediaPrincipal());
            }
        }

        return publication;
    }
}
