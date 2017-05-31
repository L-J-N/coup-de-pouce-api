package com.cdp.service.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.data.repository.AdresseRepository;
import com.cdp.data.repository.projet.PrProjetRepository;
import com.cdp.data.repository.projet.PrStatutProjetRepository;
import com.cdp.enumeration.StatutProjetEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jabuf on 23/02/17.
 */
@Service
public class StatutProjetService {

    @Autowired
    private PrStatutProjetRepository statutProjetRepository;

    void init(PrProjet projet) {

        if (projet.getStatuts() == null || projet.getStatuts().isEmpty()) {

            PrStatutProjet statutProjet = new PrStatutProjet();
            statutProjet.setDateDebut(new Date());
            statutProjet.setProjet(projet);
            statutProjet.setStatutProjet(StatutProjetEnum.CREE);

            statutProjetRepository.save(statutProjet);
        }
    }

}
