package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.casutilisation.CreerCompte;
import com.tutoriel.ddd.core.noyaupartage.application.commande.CreerCompteCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;

/**
 * @author Christian Amani 2020-05-27
 */
public class CreerCompteCommandeGestionnaire implements GestionnaireCommande<CreerCompteCommande> {

    private final CreerCompte creerCompte;

    public CreerCompteCommandeGestionnaire(
            UtilisateurRepositoryPort utilisateurPortRepository,
            RoleRepositoryPort roleRepositoryPort) {

        creerCompte = new CreerCompte(
                utilisateurPortRepository, roleRepositoryPort);

    }

    @Override
    public void execute(CreerCompteCommande commande) {
        creerCompte.cree(commande);
    }

}
