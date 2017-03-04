package com.cdp.service.utilisateur;

import com.cdp.data.entity.projet.PrProjet;
import com.cdp.data.entity.projet.PrStatutProjet;
import com.cdp.data.entity.utilisateur.UsrUtilisateur;
import com.cdp.data.repository.projet.PrStatutProjetRepository;
import com.cdp.data.repository.utilisateur.UsrUtilisateurRepository;
import com.cdp.enumeration.StatutProjetEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jabuf on 23/02/17.
 */
@Service
public class UtilisateurService {

    @Autowired
    private UsrUtilisateurRepository utilisateurRepository;

    public UsrUtilisateur getById(Long id) {

        return utilisateurRepository.findOne(id);
    }

    public void save(UsrUtilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

}
