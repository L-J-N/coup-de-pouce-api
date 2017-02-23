package com.cdp.web.converter;


import com.cdp.data.entity.Adresse;
import com.cdp.web.dto.AdresseDto;
import org.springframework.stereotype.Component;

/**
 * Created by jabuf on 22/02/17.
 */
@Component
public class AdresseConverter {

    public AdresseDto toDto(final Adresse adresse) {

        AdresseDto adresseDto = null;

        if (adresse != null) {

            adresseDto = new AdresseDto();
            adresseDto.setId(adresse.getId());
        }

        return adresseDto;
    }
}
