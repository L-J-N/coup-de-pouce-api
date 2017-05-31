package com.cdp.web.controller.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrPublication;
import com.cdp.service.projet.ProjetService;
import com.cdp.service.projet.PublicationService;
import com.cdp.web.converter.projet.PublicationConverter;
import com.cdp.web.dto.projet.PublicationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jabuf on 22/02/17.
 */

@RestController
@Api(value = "/publications/v1", description = "Service REST pour l'entité Publication")
@RequestMapping(value="/publications/v1")
public class PublicationController {

    @Autowired
    private ProjetService projetService;

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationConverter publicationConverter;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Renvoie la publication correspondante au projet passé en paramétre", response = PublicationDto.class)
    public PublicationDto getByProjetId(@RequestParam(value="projet") Long idProjet) {

        PublicationDto publicationDto = null;

        PrProjet projet = projetService.getById(idProjet);

        if (projet != null) {

            PrPublication publication = publicationService.getByProjet(projet);

            if (publication != null) {
                publicationDto = publicationConverter.toDto(publication);
            }
        }

        return publicationDto;
    }

}