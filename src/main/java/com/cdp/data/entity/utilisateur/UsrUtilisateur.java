package com.cdp.data.entity.utilisateur;


import com.cdp.data.entity.projet.PrProjet;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jabuf on 22/02/17.
 */
@Entity
public class UsrUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<PrProjet> projets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
