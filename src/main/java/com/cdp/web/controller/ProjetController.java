package com.cdp.web.controller;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.service.projet.ProjetService;
import com.cdp.web.converter.ProjetConverter;
import com.cdp.web.dto.ProjetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */

@RestController
@RequestMapping(value="/projets")
public class ProjetController {


    @Autowired
    private ProjetConverter projetConverter;

    @Autowired
    private ProjetService projetService;

    @RequestMapping(method= RequestMethod.GET)
    public List<ProjetDto> getByStatut(@RequestParam(value="statut") String statut) {

        List<ProjetDto> projetsDto = new ArrayList<>();
        List<PrProjet> projets = projetService.getByStatut(statut);

        if (!projets.isEmpty()) {

            for (PrProjet projet : projets) {
                projetsDto.add(projetConverter.toDto(projet));
            }
        }

        return projetsDto;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ProjetDto getById(@PathVariable("id") Long id) {

        PrProjet projet = projetService.getById(id);
        ProjetDto projetDto = null;

        if (projet != null) {
            projetDto = projetConverter.toDto(projet);
        }

        return projetDto;
    }

    @RequestMapping(method= RequestMethod.POST)
    public void create(@RequestBody ProjetDto input) {

        PrProjet projet = projetConverter.toEntity(input);
    }

}
