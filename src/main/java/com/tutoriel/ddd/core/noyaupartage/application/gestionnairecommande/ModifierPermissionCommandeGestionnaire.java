package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.casutilisation.ModifierPermission;
import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierPermissionCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;

public class ModifierPermissionCommandeGestionnaire implements GestionnaireCommande<ModifierPermissionCommande> {

    private final ModifierPermission modifierPermission;

    public ModifierPermissionCommandeGestionnaire(PermissionRepositoryPort permissionPort) {
        this.modifierPermission = new ModifierPermission(permissionPort);
    }

    @Override
    public void execute(ModifierPermissionCommande commande) {
        modifierPermission.modifier(commande);
    }
}
