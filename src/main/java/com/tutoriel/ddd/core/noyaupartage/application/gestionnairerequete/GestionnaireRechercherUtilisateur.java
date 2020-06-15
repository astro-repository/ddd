package com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireRequete;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class GestionnaireRechercherUtilisateur implements GestionnaireRequete<UUID, Utilisateur> {

  private final UtilisateurRepositoryPort utilisateurRepositoryPort;

  public GestionnaireRechercherUtilisateur(
      UtilisateurRepositoryPort utilisateurRepositoryPort) {
    this.utilisateurRepositoryPort = utilisateurRepositoryPort;
  }

  @Override
  public Utilisateur requete(UUID critere) {
    return utilisateurRepositoryPort.rechercherParId(critere);
  }

  @Override
  public List<Utilisateur> requete() {
    return utilisateurRepositoryPort.listeUtilisateurs();
  }
}
