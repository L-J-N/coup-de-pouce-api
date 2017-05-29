package com.cdp.web.converter;


import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrPublication;
import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.service.projet.ProjetService;
import com.cdp.service.projet.PublicationService;
import com.cdp.web.dto.ProjetVignetteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class ProjetVignetteConverter {

    @Autowired
    private ProjetService projetService;

    @Autowired
    private PublicationService publicationService;

    public ProjetVignetteDto toDto(final PrProjet projet) {

        ProjetVignetteDto projetVignetteDto = null;

        if (projet != null) {

            projetVignetteDto = new ProjetVignetteDto();
            projetVignetteDto.setIdProjet(projet.getId());
            projetVignetteDto.setNom(projet.getNom());
            projetVignetteDto.setDescriptionCourte(projet.getDescriptionCourte());
            projetVignetteDto.setSommeDemandee(projet.getSommeDemandee());
            projetVignetteDto.setSommeRecolte(projet.getSommeRecolte());
            projetVignetteDto.setDelaiRecolte(projet.getDelaiRecolte());

            PrStatutProjet statut = projetService.getCurrentStatut(projet);

            if (statut != null) {

                projetVignetteDto.setStatut(statut.getStatutProjet());

                if (statut.getDateDebut() != null) {
                    projetVignetteDto.setDateDebutPublication(statut.getDateDebut());
                }
            }

            PrPublication publication = publicationService.getByProjet(projet);

            if (publication != null) {
                projetVignetteDto.setImageAffichage(publication.getImageAffichage());
            }
        }

        return projetVignetteDto;
    }

}
