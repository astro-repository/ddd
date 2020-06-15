package com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireRequete;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;

import java.util.List;
import java.util.UUID;

public class GestionnaireRechercherRole implements GestionnaireRequete<UUID, Role> {

    private final RoleRepositoryPort roleRepositoryPort;

    public GestionnaireRechercherRole(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public Role requete(UUID critere) {
        return roleRepositoryPort.rechercherRoleParId(critere);
    }

    @Override
    public List<Role> requete() {
        return roleRepositoryPort.listeRole();
    }
}
