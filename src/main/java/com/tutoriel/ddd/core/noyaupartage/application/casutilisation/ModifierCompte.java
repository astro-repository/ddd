package com.tutoriel.ddd.core.noyaupartage.application.casutilisation;

import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierCompteCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.UUID;

public class ModifierCompte {

    private final UtilisateurRepositoryPort utilisateurRepositoryPort;

    public ModifierCompte(UtilisateurRepositoryPort utilisateurRepositoryPort) {
        this.utilisateurRepositoryPort = utilisateurRepositoryPort;
    }

    public void modifier(ModifierCompteCommande cmd) {

        UUID idUtilisateur = cmd.getIdUtilisateur();
        Utilisateur utilisateur = utilisateurRepositoryPort.rechercherParId(idUtilisateur);

        if ( ! cmd.getNom().isEmpty() ) utilisateur.setNom( cmd.getNom() );
        if ( ! cmd.getPrenom().isEmpty() ) utilisateur.setPrenom(cmd.getPrenom());
        if ( cmd.getAge() != 0 ) utilisateur.setAge( cmd.getAge() );

        if ( cmd.getEtatCompte() != null ) utilisateur.getCompte().setEtatCompte(cmd.getEtatCompte());

        if ( ! cmd.getLogin().isEmpty() ) utilisateur.getCompte().setLogin( cmd.getLogin() );
        if ( ! cmd.getPassword().isEmpty() ) utilisateur.getCompte().setPassword( cmd.getPassword() );

        utilisateurRepositoryPort.modifier(utilisateur);

    }
}
