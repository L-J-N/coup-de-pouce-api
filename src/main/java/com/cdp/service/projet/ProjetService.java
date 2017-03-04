package com.cdp.service.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.data.repository.AdresseRepository;
import com.cdp.data.repository.projet.PrProjetRepository;
import com.cdp.data.repository.projet.PrStatutProjetRepository;
import com.cdp.enumeration.StatutProjetEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jabuf on 23/02/17.
 */
@Service
public class ProjetService {

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private PrProjetRepository projetRepository;

    @Autowired
    private PrStatutProjetRepository statutProjetRepository;

    public PrProjet getById(Long id) {

        return projetRepository.findOne(id);
    }

    public void save(PrProjet projet) {

        if (projet.getAdresse() != null) {
            adresseRepository.save(projet.getAdresse());
        }

        projetRepository.save(projet);
    }

    public PrStatutProjet getCurrentStatut(PrProjet projet) {

        PrStatutProjet statut = null;

        for (PrStatutProjet itStatut : projet.getStatuts()) {
            if (itStatut.getDateFin() == null) {
                statut = itStatut;
            }
        }

        return statut;
    }

    public List<PrProjet> getByStatut(String statut) {

        List<PrStatutProjet> statutProjets = statutProjetRepository.findByStatutProjetAndDateFinIsNull(StatutProjetEnum.toEnum(statut));
        List<PrProjet> projets = new ArrayList<>();

        if (!statutProjets.isEmpty()) {
            for (PrStatutProjet statutProjet : statutProjets) {
                projets.add(statutProjet.getProjet());
            }
        }

        return projets;
    }


}
