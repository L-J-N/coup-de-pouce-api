package com.cdp.service.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrPublication;
import com.cdp.data.repository.projet.PrPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jabuf on 23/02/17.
 *
 * Cette classe correspond au widget affichant uniquement une partie des informations du projet.
 * Plus d'informations ici : https://github.com/L-J-N/site/wiki/Projet-liste-bloc-projet
 */
@Service
public class PublicationService {

    @Autowired
    private PrPublicationRepository publicationRepository;

    public void save(PrPublication publication) {
        publicationRepository.save(publication);
    }

    public PrPublication getByProjet(PrProjet projet) {

        return publicationRepository.findByProjet(projet);
    }

    /**
     * Initialise la publication d'un projet si celui-ci n'en a pas
     * @param projet le projet à mettre à jour
     */
    public void init(PrProjet projet) {

        if (projet.getPublication() == null) {

            PrPublication publication = new PrPublication();
            publication.setProjet(projet);

            publicationRepository.save(publication);
        }
    }

}
