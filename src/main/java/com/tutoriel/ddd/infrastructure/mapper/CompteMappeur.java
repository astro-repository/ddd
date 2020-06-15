package com.tutoriel.ddd.infrastructure.mapper;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Compte;
import com.tutoriel.ddd.infrastructure.entite.CompteTable;
import org.springframework.stereotype.Service;

@Service
public class CompteMappeur {

    public CompteTable compteVersTable(Compte compte) {
        return new CompteTable(compte);
    }

    public Compte tableVersCompte(CompteTable table) {

        Compte compte = new Compte();
        compte.setId(table.getId());
        compte.setEtatCompte(table.getEtatCompte());
        compte.setLogin(table.getLogin());
        compte.setPassword(table.getPassword());

        return compte;

    }
}
