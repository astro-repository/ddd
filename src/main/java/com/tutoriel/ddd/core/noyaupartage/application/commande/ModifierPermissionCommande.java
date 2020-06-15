package com.tutoriel.ddd.core.noyaupartage.application.commande;

import java.util.UUID;

public class ModifierPermissionCommande {

    protected UUID id;
    protected String libelle;
    protected String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
