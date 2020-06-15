package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;

import java.util.UUID;

public class SupprimerRoleParId implements GestionnaireCommande<UUID> {

    private final RoleRepositoryPort roleRepositoryPort;

    public SupprimerRoleParId(RoleRepositoryPort roleRepositoryPort) {

        this.roleRepositoryPort = roleRepositoryPort;

    }

    @Override
    public void execute(UUID commande) {

        roleRepositoryPort.supprimerParId(commande);

    }

}
