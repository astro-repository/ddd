package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;

import java.util.UUID;

public class SupprimerCompteParId implements GestionnaireCommande<UUID> {

    private final UtilisateurRepositoryPort utilisateurRepositoryPort;

    public SupprimerCompteParId(UtilisateurRepositoryPort utilisateurRepositoryPort) {
        this.utilisateurRepositoryPort = utilisateurRepositoryPort;
    }

    @Override
    public void execute(UUID commande) {
        utilisateurRepositoryPort.supprimerParId(commande);
    }

}
