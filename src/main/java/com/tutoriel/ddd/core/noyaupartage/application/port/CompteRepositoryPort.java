package com.tutoriel.ddd.core.noyaupartage.application.port;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Compte;

import java.util.UUID;

/**
 * <p>Interface pour le port du repository de l'entité {@link Compte}.</p> *
 *
 * @author Christian Amani 2020-05-27
 */

public interface CompteRepositoryPort {

    void enregistrer(Compte compte);

    void supprimerParId(UUID id);

}
