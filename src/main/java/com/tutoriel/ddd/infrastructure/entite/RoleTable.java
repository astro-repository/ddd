package com.tutoriel.ddd.infrastructure.entite;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class RoleTable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    protected UUID id;

    @Column
    protected String libelle;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<PermissionTable> permissionsTable = new HashSet<>();

    public RoleTable() {
    }

    public RoleTable(Role role) {
        this.libelle = role.getLibelle();
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

    public Set<PermissionTable> getPermissionsTable() {
        return permissionsTable;
    }

    public void setPermissionsTable(Set<PermissionTable> permissionsTable) {
        this.permissionsTable = permissionsTable;
    }

}
