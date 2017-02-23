package com.cdp.data.entity.projet;

import com.cdp.enumeration.StatutProjetEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jabuf on 23/02/17.
 */
@Entity
public class PrStatutProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private PrProjet projet;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatutProjetEnum statutProjet;

    @NotNull
    private Date dateDebut;

    private Date dateFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public PrProjet getProjet() {
        return projet;
    }

    public void setProjet(PrProjet projet) {
        this.projet = projet;
    }

    public StatutProjetEnum getStatutProjet() {
        return statutProjet;
    }

    public void setStatutProjet(StatutProjetEnum statutProjet) {
        this.statutProjet = statutProjet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
