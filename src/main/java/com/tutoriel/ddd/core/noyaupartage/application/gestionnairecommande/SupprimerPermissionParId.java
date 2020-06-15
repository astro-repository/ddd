package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;

import java.util.UUID;

public class SupprimerPermissionParId implements GestionnaireCommande<UUID> {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public SupprimerPermissionParId(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    @Override
    public void execute(UUID id) {
        permissionRepositoryPort.supprimerParId(id);
    }
}
