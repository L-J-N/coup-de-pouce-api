package com.cdp.web.dto;

/**
 * Created by jabuf on 22/02/17.
 */
public class AdresseDto {

    private Long id;

    private Integer numero;

    private String voie;

    private String complement1;

    private String complement2;

    private String codePostal;

    private String ville;

    private String pays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getComplement1() {
        return complement1;
    }

    public void setComplement1(String complement1) {
        this.complement1 = complement1;
    }

    public String getComplement2() {
        return complement2;
    }

    public void setComplement2(String complement2) {
        this.complement2 = complement2;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
