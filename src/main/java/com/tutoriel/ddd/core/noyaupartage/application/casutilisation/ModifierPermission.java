package com.tutoriel.ddd.core.noyaupartage.application.casutilisation;

import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierPermissionCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;

public class ModifierPermission {

    private final PermissionRepositoryPort permissionPort;

    public ModifierPermission(PermissionRepositoryPort permissionPort) {
        this.permissionPort = permissionPort;
    }

    public void modifier(ModifierPermissionCommande cmd) {
        Permission permission = new Permission(
                cmd.getLibelle(),
                cmd.getDescription()
        );

        permission.setId( cmd.getId() );
        permissionPort.modifier(permission);

    }

}
