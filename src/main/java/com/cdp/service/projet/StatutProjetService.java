package com.cdp.service.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.data.repository.projet.PrStatutProjetRepository;
import com.cdp.enumeration.StatutProjetEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by jabuf on 23/02/17.
 */
@Service
public class StatutProjetService {

    @Autowired
    private PrStatutProjetRepository statutProjetRepository;

    @Autowired
    private PublicationService publicationService;

    /**
     * Initialise le statut d'un projet
     * @param projet le projet à mettre à jour
     */
    void init(PrProjet projet) {

        if (projet.getStatuts() == null || projet.getStatuts().isEmpty()) {

            PrStatutProjet statutProjet = new PrStatutProjet();
            statutProjet.setDateDebut(new Date());
            statutProjet.setProjet(projet);
            statutProjet.setStatutProjet(StatutProjetEnum.CREE);

            statutProjetRepository.save(statutProjet);
        }
    }

    /**
     * Met à jour le statut d'un projet
     * @param projet le projet à mettre à jour
     * @param statut le statut actif
     */
    public void updateStatut(PrProjet projet, String statut) {

        List<PrStatutProjet> statuts = statutProjetRepository.findByProjet(projet);

        //On archive l'ancien statut actif
        for (PrStatutProjet itStatut : statuts) {

            if (itStatut.getDateFin() == null) {
                itStatut.setDateFin(new Date());
            }
        }

        //On en crée un nouveau
        PrStatutProjet newStatut = new PrStatutProjet();
        newStatut.setProjet(projet);
        newStatut.setStatutProjet(StatutProjetEnum.valueOf(statut));
        newStatut.setDateDebut(new Date());

        //On le rattache au projet
        statuts.add(newStatut);

        statutProjetRepository.save(statuts);

        //Si le projet passe en PUBLIE, alors on lui rattache une publication
        System.out.println(statut);
        System.out.println(StatutProjetEnum.PUBLIE);
        System.out.println(StatutProjetEnum.PUBLIE.equals(statut));
        if (StatutProjetEnum.PUBLIE.equals(statut)) {
            publicationService.init(projet);
        }
    }

}
