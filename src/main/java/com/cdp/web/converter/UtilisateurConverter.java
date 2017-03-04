package com.cdp.web.converter;


import com.cdp.data.entity.utilisateur.UsrUtilisateur;
import com.cdp.service.utilisateur.UtilisateurService;
import com.cdp.web.dto.UtilisateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class UtilisateurConverter {

    @Autowired
    UtilisateurService utilisateurService;

    public UtilisateurDto toDto(final UsrUtilisateur utilisateur) {

        UtilisateurDto utilisateurDto = null;

        if (utilisateur != null) {

            utilisateurDto = new UtilisateurDto();
            utilisateurDto.setId(utilisateur.getId());
        }

        return utilisateurDto;
    }

    public UsrUtilisateur toEntity(UtilisateurDto utilisateurDto) {

        UsrUtilisateur utilisateur = new UsrUtilisateur();

        if (utilisateurDto.getId() != null) {
            utilisateur = utilisateurService.getById(utilisateurDto.getId());
        } else {
            //TODO
        }

        return utilisateur;
    }
}
