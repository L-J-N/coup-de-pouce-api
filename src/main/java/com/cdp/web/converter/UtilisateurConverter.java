package com.cdp.web.converter;


import com.cdp.data.entity.utilisateur.UsrUtilisateur;
import com.cdp.web.dto.UtilisateurDto;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class UtilisateurConverter {

    public UtilisateurDto toDto(final UsrUtilisateur utilisateur) {

        UtilisateurDto utilisateurDto = null;

        if (utilisateur != null) {

            utilisateurDto = new UtilisateurDto();
            utilisateurDto.setId(utilisateur.getId());
        }

        return utilisateurDto;
    }
}
