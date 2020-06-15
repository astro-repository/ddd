package com.tutoriel.ddd.core.noyaupartage.application.commande;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ModifierRoleCommande {

    protected UUID id;
    protected String libelle;
    private List<UUID> permissionsId;

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

    public List<UUID> getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(List<UUID> permissionsId) {
        this.permissionsId = permissionsId;
    }
}
