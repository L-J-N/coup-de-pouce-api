package com.cdp.data.repository.projet;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrPublication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jabuf on 22/02/17.
 */
public interface PrPublicationRepository extends JpaRepository<PrPublication, Long> {

    PrPublication findByProjet(PrProjet projet);

}
