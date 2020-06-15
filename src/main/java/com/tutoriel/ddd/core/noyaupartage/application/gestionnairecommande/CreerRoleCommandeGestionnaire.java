package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.casutilisation.CreerRole;
import com.tutoriel.ddd.core.noyaupartage.application.commande.CreerRoleCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;

public class CreerRoleCommandeGestionnaire implements GestionnaireCommande<CreerRoleCommande> {

    private final CreerRole creerRole;

    public CreerRoleCommandeGestionnaire(RoleRepositoryPort roleRepositoryPort, PermissionRepositoryPort permissionRepositoryPort) {
        this.creerRole = new CreerRole(roleRepositoryPort, permissionRepositoryPort);
    }

    @Override
    public void execute(CreerRoleCommande commande) {
        creerRole.creer(commande);
    }
}
