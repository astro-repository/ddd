package com.tutoriel.ddd.core.noyaupartage.application.port;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;

import java.util.List;
import java.util.UUID;

public interface PermissionRepositoryPort {

    Permission rechercherParId(UUID uuid);
    List<Permission> listePermission();

    void creer(Permission permission);

    void modifier(Permission permission);

    void supprimerParId(UUID id);

}
