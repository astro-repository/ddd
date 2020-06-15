package com.tutoriel.ddd.core.noyaupartage.application.port;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>Interface pour le port du repository de l'entité {@link Utilisateur}.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public interface UtilisateurRepositoryPort {

    Utilisateur enregistrer(Utilisateur utilisateur);

    Utilisateur rechercherParId(UUID identifiant);

    void modifier(Utilisateur utilisateur);

    List<Utilisateur> listeUtilisateurs();

    Optional<Utilisateur> rechercherParIdAvecOptional(UUID identifiant);

    void supprimerParId(UUID commande);

}
