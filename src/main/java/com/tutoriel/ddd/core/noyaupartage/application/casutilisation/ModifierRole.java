package com.tutoriel.ddd.core.noyaupartage.application.casutilisation;

import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierRoleCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModifierRole {

    private final RoleRepositoryPort roleRepositoryPort;
    private final PermissionRepositoryPort permissionPort;

    public ModifierRole(RoleRepositoryPort roleRepositoryPort, PermissionRepositoryPort permissionPort) {
        this.roleRepositoryPort = roleRepositoryPort;
        this.permissionPort = permissionPort;
    }

    public void modifier(ModifierRoleCommande cmd) {

        Set<Permission> permissions = new HashSet<>();
        cmd.getPermissionsId().forEach(uuid -> {
            permissions.add( permissionPort.rechercherParId(uuid) );
        });

        Role role = roleRepositoryPort.rechercherRoleParId( cmd.getId() );

        if ( ! cmd.getLibelle().isEmpty() ) role.setLibelle( cmd.getLibelle() );
        if ( ! cmd.getPermissionsId().isEmpty() ) role.setPermissions( permissions );

        roleRepositoryPort.modifier(role);

    }

}
