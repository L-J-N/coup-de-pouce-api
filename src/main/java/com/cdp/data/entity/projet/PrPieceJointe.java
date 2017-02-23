package com.cdp.data.entity.projet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jabuf on 23/02/17.
 */
@Entity
public class PrPieceJointe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String urlPieceJointe;

    @NotNull
    private Date dateDepot;

    @NotNull
    @ManyToOne
    private PrProjet projet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlPieceJointe() {
        return urlPieceJointe;
    }

    public void setUrlPieceJointe(String urlPieceJointe) {
        this.urlPieceJointe = urlPieceJointe;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public PrProjet getProjet() {
        return projet;
    }

    public void setProjet(PrProjet projet) {
        this.projet = projet;
    }
}
