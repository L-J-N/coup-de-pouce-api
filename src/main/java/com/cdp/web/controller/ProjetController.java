package com.cdp.web.controller;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.service.projet.ProjetService;
import com.cdp.web.converter.ProjetConverter;
import com.cdp.web.dto.ProjetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */

@RestController
@Api(value = "/projets/v1", description = "Service REST pour l'entité Projet")
@RequestMapping(value="/projets/v1")
public class ProjetController {


    @Autowired
    private ProjetConverter projetConverter;

    @Autowired
    private ProjetService projetService;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Renvoie la liste des projets correspondants au statut passé en paramétre", response = ProjetDto.class)
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
    @ApiOperation(value = "Renvoie le projet correspondant à l'identifiant passé en paramétre", response = ProjetDto.class)
    public ProjetDto getById(@PathVariable("id") Long id) {

        PrProjet projet = projetService.getById(id);
        ProjetDto projetDto = null;

        if (projet != null) {
            projetDto = projetConverter.toDto(projet);
        }

        return projetDto;
    }

    @RequestMapping(method= RequestMethod.POST, consumes = { "application/json" })
    @ApiOperation(value = "Créé le projet passé en paramétre")
    @ResponseBody
    public ResponseEntity create(@RequestBody ProjetDto input) {

        PrProjet projet = projetConverter.toEntity(input);
        projetService.save(projet);

        if (projet != null) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            //TODO
            return new ResponseEntity(HttpStatus.CREATED);
        }

    }

}
