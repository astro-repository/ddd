package com.tutoriel.ddd.core.noyaupartage.application.casutilisation;

import com.tutoriel.ddd.core.noyaupartage.application.commande.CreerPermissionCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;

public class CreerPermission {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public CreerPermission(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    public void creer(CreerPermissionCommande commande) {

        Permission permission = new Permission(
                commande.getLibelle(),
                commande.getDescription()
        );
        permissionRepositoryPort.creer(permission);
    }
}
