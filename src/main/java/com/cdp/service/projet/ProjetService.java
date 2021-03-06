package com.cdp.service.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.data.repository.AdresseRepository;
import com.cdp.data.repository.projet.PrProjetRepository;
import com.cdp.data.repository.projet.PrStatutProjetRepository;
import com.cdp.enumeration.StatutProjetEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private StatutProjetService statutProjetService;

    public PrProjet getById(Long id) {

        return projetRepository.findOne(id);
    }

    public void save(PrProjet projet) {

        if (projet.getAdresse() != null) {
            adresseRepository.save(projet.getAdresse());
        }

        projetRepository.save(projet);

        if (CollectionUtils.isEmpty(projet.getStatuts())) {
            //Si le projet n'a pas de statut, on lui en crée un
            statutProjetService.init(projet);
        }
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

    public List<PrProjet> getList(String statut) {

        List<PrStatutProjet> statutProjets;

        if (!StringUtils.isEmpty(statut)) {
            statutProjets = statutProjetRepository.findByStatutProjetAndDateFinIsNull(StatutProjetEnum.toEnum(statut));
        } else {
            statutProjets = statutProjetRepository.findByDateFinIsNull();
        }

        List<PrProjet> projets = new ArrayList<>();

        if (!statutProjets.isEmpty()) {
            for (PrStatutProjet statutProjet : statutProjets) {
                projets.add(statutProjet.getProjet());
            }
        }

        return projets;
    }

    public void updateSomme(PrProjet projet, int somme) {

        projet.setSommeRecolte(projet.getSommeRecolte() + somme);
        projetRepository.save(projet);
    }

}
