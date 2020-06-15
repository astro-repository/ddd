package com.tutoriel.ddd.core.noyaupartage.application.casutilisation;

import com.tutoriel.ddd.core.noyaupartage.application.commande.CreerRoleCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CreerRole {

    private final RoleRepositoryPort roleRepositoryPort;
    private final PermissionRepositoryPort permissionRepositoryPort;

    public CreerRole(RoleRepositoryPort roleRepositoryPort, PermissionRepositoryPort permissionRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    public void creer(CreerRoleCommande commande) {

        Set<Permission> permissionsList = commande.getPermissionsId().stream()
                .map(permissionRepositoryPort::rechercherParId)
                .collect(Collectors.toSet());

        Role role = new Role(
                commande.getLibelle(),
                permissionsList
        );

        roleRepositoryPort.creer(role);
    }

}
