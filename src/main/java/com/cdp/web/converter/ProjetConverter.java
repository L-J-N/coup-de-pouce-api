package com.cdp.web.converter;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.service.projet.ProjetService;
import com.cdp.web.dto.ProjetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class ProjetConverter {

    @Autowired
    private ProjetService projetService;

    @Autowired
    private UtilisateurConverter utilisateurConverter;

    @Autowired
    private AdresseConverter adresseConverter;

    public ProjetDto toDto(final PrProjet projet) {

        ProjetDto projetDto = null;

        if (projet != null) {

            projetDto = new ProjetDto();
            projetDto.setId(projet.getId());
            projetDto.setNom(projet.getNom());
            projetDto.setCreateur(utilisateurConverter.toDto(projet.getCreateur()));
            projetDto.setStatut(projetService.getCurrentStatut(projet));
            projetDto.setTypeProjet(projet.getTypeProjet());
            projetDto.setDescriptionCourte(projet.getDescriptionCourte());
            projetDto.setSommeDemandee(projet.getSommeDemandee());
            projetDto.setSommeRecolte(projet.getSommeRecolte());
            projetDto.setDelaiRecolte(projet.getDelaiRecolte());
            projetDto.setAdresse(adresseConverter.toDto(projet.getAdresse()));
        }

        return projetDto;
    }

    public PrProjet toEntity(final ProjetDto projetDto) {
        return new PrProjet();
    }
}
