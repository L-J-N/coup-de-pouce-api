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

    public Adresse toEntity(AdresseDto adresseDto) {

        Adresse adresse = null;

        if (adresseDto != null) {

            adresse = new Adresse();

            adresse.setId(adresseDto.getId());
            adresse.setCodePostal(adresseDto.getCodePostal());
            adresse.setVille(adresseDto.getPays());
            adresse.setVoie(adresseDto.getVoie());
            adresse.setNumero(adresseDto.getNumero());
            adresse.setComplement1(adresseDto.getComplement1());
            adresse.setComplement2(adresseDto.getComplement2());
            adresse.setPays(adresseDto.getPays());
        }

        return adresse;
    }
}
