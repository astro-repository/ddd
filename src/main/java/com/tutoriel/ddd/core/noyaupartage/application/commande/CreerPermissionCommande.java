package com.tutoriel.ddd.core.noyaupartage.application.commande;

import java.util.UUID;

public class CreerPermissionCommande {

    private String libelle;
    private String description;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
