package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.casutilisation.CreerPermission;
import com.tutoriel.ddd.core.noyaupartage.application.commande.CreerPermissionCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;

public class CreerPermissionCommandeGestionnaire implements GestionnaireCommande<CreerPermissionCommande> {

    private final CreerPermission creerPermission;

    public CreerPermissionCommandeGestionnaire(PermissionRepositoryPort permissionRepository) {
        this.creerPermission = new CreerPermission(permissionRepository);
    }

    @Override
    public void execute(CreerPermissionCommande commande) {
        creerPermission.creer(commande);
    }
}
