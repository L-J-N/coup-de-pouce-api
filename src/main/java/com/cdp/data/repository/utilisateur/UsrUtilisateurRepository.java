package com.cdp.data.repository.utilisateur;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.utilisateur.UsrUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jabuf on 22/02/17.
 */
public interface UsrUtilisateurRepository extends JpaRepository<UsrUtilisateur, Long> {

}
