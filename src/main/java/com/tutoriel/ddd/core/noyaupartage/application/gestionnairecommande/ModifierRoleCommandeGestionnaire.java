package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.casutilisation.ModifierRole;
import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierRoleCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;

public class ModifierRoleCommandeGestionnaire implements GestionnaireCommande<ModifierRoleCommande> {

    private final ModifierRole modifierRole;

    public ModifierRoleCommandeGestionnaire(RoleRepositoryPort roleRepositoryPort, PermissionRepositoryPort permissionRepositoryPort) {
        this.modifierRole = new ModifierRole(roleRepositoryPort, permissionRepositoryPort);
    }

    @Override
    public void execute(ModifierRoleCommande commande) {
        modifierRole.modifier(commande);
    }
}
