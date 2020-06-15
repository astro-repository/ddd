package com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireRequete;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;

import java.util.List;
import java.util.UUID;

public class GestionnaireRechercherPermission implements GestionnaireRequete<UUID, Permission> {

    private final PermissionRepositoryPort permissionRepositoryPort;

    public GestionnaireRechercherPermission(PermissionRepositoryPort permissionRepositoryPort) {
        this.permissionRepositoryPort = permissionRepositoryPort;
    }

    @Override
    public Permission requete(UUID critere) {
        return permissionRepositoryPort.rechercherParId(critere);
    }

    @Override
    public List<Permission> requete() {
        return permissionRepositoryPort.listePermission();
    }
}
