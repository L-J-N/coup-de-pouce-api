package com.cdp.enumeration;

/**
 * Created by jabuf on 22/02/17.
 */
public enum StatutProjetEnum {

    EN_COURS_CREATION,
    CREE,
    REFUSE,
    En_ATTENTE_RDV,
    EN_ATTENTE_PUBLICATION,
    PUBLIE,
    FINANCE,
    NON_FINANCE;


    public static StatutProjetEnum toEnum(String statut) throws RuntimeException {

        StatutProjetEnum statutProjetEnum;

        try {
            statutProjetEnum = StatutProjetEnum.valueOf(statut);
        } catch (IllegalArgumentException e) {
            //TODO some logs
            throw new RuntimeException(
                    "Invalid value for enum :" +statut);
        }

        return statutProjetEnum;
    }
}

