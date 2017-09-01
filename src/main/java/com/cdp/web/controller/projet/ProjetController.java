package com.cdp.web.controller.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.service.projet.ProjetService;
import com.cdp.service.projet.StatutProjetService;
import com.cdp.web.converter.projet.ProjetConverter;
import com.cdp.web.converter.projet.ProjetVignetteConverter;
import com.cdp.web.dto.projet.ProjetDto;
import com.cdp.web.dto.projet.ProjetVignetteDto;
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
    private ProjetVignetteConverter projetVignetteConverter;

    @Autowired
    private ProjetService projetService;

    @Autowired
    private StatutProjetService statutProjetService;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value = "Renvoie la liste des projets correspondants au statut passé en paramétre", response = ProjetDto.class)
    public List<ProjetDto> getList(@RequestParam(value="statut", required = false) String statut) {

        List<ProjetDto> projetsDto = new ArrayList<>();
        List<PrProjet> projets = projetService.getList(statut);

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

    @RequestMapping(value="/vignette", method= RequestMethod.GET)
    @ApiOperation(value = "Renvoie la liste des vignettes des projets correspondants au statut passé en paramétre", response = ProjetVignetteDto.class)
    public List<ProjetVignetteDto> getVignettesByStatut(@RequestParam(value="statut") String statut) {

        List<ProjetVignetteDto> projetVignettesDto = new ArrayList<>();
        List<PrProjet> projets = projetService.getList(statut);

        if (!projets.isEmpty()) {

            for (PrProjet projet : projets) {
                projetVignettesDto.add(projetVignetteConverter.toDto(projet));
            }
        }

        return projetVignettesDto;
    }

    @RequestMapping(value="/vignette/{id}", method= RequestMethod.GET)
    @ApiOperation(value = "Renvoie la vignette du projet correspondant à l'identifiant passé en paramétre", response = ProjetVignetteDto.class)
    public ProjetVignetteDto getVignetteById(@PathVariable("id") Long id) {

        PrProjet projet = projetService.getById(id);
        ProjetVignetteDto projetVignetteDto = null;

        if (projet != null) {
            projetVignetteDto = projetVignetteConverter.toDto(projet);
        }

        return projetVignetteDto;
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

    @RequestMapping(method= RequestMethod.PUT, consumes = { "application/json" })
    @ApiOperation(value = "Met à jour un projet")
    @ResponseBody
    public ProjetDto update(@RequestBody ProjetDto input) {

        PrProjet projet = projetConverter.toEntity(input);
        projetService.save(projet);
        ProjetDto projetDto = projetConverter.toDto(projet);


        if (projetDto != null) {
            return projetDto;
        } else {
            //TODO
            return input;
        }
    }

    @RequestMapping(method= RequestMethod.PATCH, consumes = { "application/json" })
    @ApiOperation(value = "Met à jour différents attributs d'un projet")
    @ResponseBody
    public ResponseEntity updateProjet(@RequestParam(value="idProjet") Long idProjet,
                                        @RequestParam(value="statut", required = false) String statut,
                                       @RequestParam(value="somme", required = false) Integer somme) {

        PrProjet projet = projetService.getById(idProjet);

        if (projet != null) {

            if (statut != null) {
                statutProjetService.updateStatut(projet, statut);
            }

            if (somme != null) {
                projetService.updateSomme(projet, somme);
            }

            return new ResponseEntity(HttpStatus.OK);
        } else {
            //TODO
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }

}
