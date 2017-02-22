package com.cdp.web.converter;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.web.dto.ProjetDto;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class ProjetConverter {

    public ProjetDto toDto(final PrProjet projet) {

        ProjetDto projetDto = null;

        if (projet != null) {

            projetDto = new ProjetDto();
            projetDto.setId(projet.getId());
        }

        return projetDto;
    }
}
