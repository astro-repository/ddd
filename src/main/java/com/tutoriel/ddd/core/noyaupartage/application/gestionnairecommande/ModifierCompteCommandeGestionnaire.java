package com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.casutilisation.ModifierCompte;
import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierCompteCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;

public class ModifierCompteCommandeGestionnaire implements GestionnaireCommande<ModifierCompteCommande> {

    private final ModifierCompte modifierCompte;

    public ModifierCompteCommandeGestionnaire(UtilisateurRepositoryPort utilisateurRepositoryPort) {
        this.modifierCompte = new ModifierCompte(utilisateurRepositoryPort);
    }

    @Override
    public void execute(ModifierCompteCommande commande) {
        modifierCompte.modifier(commande);
    }
}
