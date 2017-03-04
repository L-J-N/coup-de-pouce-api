package com.cdp.data.repository;

import com.cdp.data.entity.Adresse;
import com.cdp.data.entity.projet.PrProjet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jabuf on 22/02/17.
 */
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
