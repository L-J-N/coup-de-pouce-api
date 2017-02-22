package com.cdp.web.controller;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.repository.PrProjetRepository;
import com.cdp.web.converter.ProjetConverter;
import com.cdp.web.dto.ProjetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */

@RestController
public class ProjetController {

    @Autowired
    private PrProjetRepository projetRepository;

    @Autowired
    private ProjetConverter projetConverter;

    @RequestMapping(value="/projets", method= RequestMethod.GET)
    public List<ProjetDto> projets() {

        List<ProjetDto> projetsDto = null;
        List<PrProjet> projets = projetRepository.findAll();

        if (!projets.isEmpty()) {

            for (PrProjet projet : projets) {
                projetsDto.add(projetConverter.toDto(projet));
            }
        }

        return projetsDto;
    }

/*    @RequestMapping(value="/projets", method= RequestMethod.GET)
    public ProjetDto projet(@RequestParam(value="id") Long id) {

        PrProjet projet = projetRepository.findOne(id);
        ProjetDto projetDto = null;

        if (projet != null) {
            projetDto = projetConverter.toDto(projet);
        }

        return projetDto;
    }*/
}
