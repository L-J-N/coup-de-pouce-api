package com.cdp.data.repository;

import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.enumeration.StatutProjetEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */
public interface PrStatutProjetRepository extends JpaRepository<PrStatutProjet, Long> {

    List<PrStatutProjet> findByStatutProjetAndDateFinIsNull(StatutProjetEnum statut);

}
