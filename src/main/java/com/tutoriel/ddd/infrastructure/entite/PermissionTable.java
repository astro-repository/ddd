package com.tutoriel.ddd.infrastructure.entite;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class PermissionTable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    protected UUID id;

    @Column
    protected String libelle;

    @Column
    protected String description;

    public PermissionTable() {
    }

    public PermissionTable(Permission permission) {
        this.libelle = permission.getLibelle();
        this.description = permission.getDescription();
    }

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

    @Override
    public String toString() {
        return "PermissionTable{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
