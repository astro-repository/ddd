package com.tutoriel.ddd.infrastructure.repository.impl;

import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;
import com.tutoriel.ddd.infrastructure.entite.UtilisateurTable;
import com.tutoriel.ddd.infrastructure.mapper.UtilisateurMappeur;
import com.tutoriel.ddd.infrastructure.repository.JpaUtilisateurRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UtilisateurRepositoryAdapteur implements UtilisateurRepositoryPort {

    private final JpaUtilisateurRepository jpaUtilisateurRepository;
    private final UtilisateurMappeur utilisateurMappeur;

    public UtilisateurRepositoryAdapteur(
            JpaUtilisateurRepository jpaUtilisateurRepository,
            UtilisateurMappeur utilisateurMappeur) {

        this.jpaUtilisateurRepository = jpaUtilisateurRepository;
        this.utilisateurMappeur = utilisateurMappeur;

    }

    @Override
    public Utilisateur enregistrer(Utilisateur utilisateur) {

        UtilisateurTable utilisateurTable = utilisateurMappeur
                .utilisateurVersUtilisateurTable(utilisateur);
        UtilisateurTable utilisateurTableEnregistrer = jpaUtilisateurRepository.save(utilisateurTable);
        return utilisateurMappeur.utilisateurTableVersUtilisateur(utilisateurTable);

    }

    @Override
    public Utilisateur rechercherParId(UUID identifiant) {

        Optional<UtilisateurTable> optionalUtilisateurTable = jpaUtilisateurRepository
                .findById(identifiant);

        if (optionalUtilisateurTable.isPresent()) {
            UtilisateurTable utilisateurTable = optionalUtilisateurTable.get();
            return utilisateurMappeur.utilisateurTableVersUtilisateur(utilisateurTable);
        }

        return null;

    }

    @Override
    public void modifier(Utilisateur utilisateur) {

        UtilisateurTable utilisateurTable = utilisateurMappeur.utilisateurVersUtilisateurTable(utilisateur);
        utilisateurTable.setId(utilisateur.getId());
        utilisateurTable.getCompteTable().setId(utilisateur.getCompte().getId());

        jpaUtilisateurRepository.save(utilisateurTable);

    }

    @Override
    public List<Utilisateur> listeUtilisateurs() {

        List<UtilisateurTable> utilisateurTables = jpaUtilisateurRepository.findAll();
        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurTables.forEach(utilisateurTable -> {
            utilisateurs.add(utilisateurMappeur.utilisateurTableVersUtilisateur(utilisateurTable));
        });

        return utilisateurs;

    }

    @Override
    public Optional<Utilisateur> rechercherParIdAvecOptional(UUID identifiant) {

        Optional<UtilisateurTable> optionalUtilisateurTable = jpaUtilisateurRepository
                .findById(identifiant);

        if (optionalUtilisateurTable.isPresent()) {

            UtilisateurTable utilisateurTable = optionalUtilisateurTable.get();
            Utilisateur utilisateur = utilisateurMappeur
                    .utilisateurTableVersUtilisateur(utilisateurTable);
            return Optional.of(utilisateur);

        }

        return Optional.empty();

    }

    @Override
    public void supprimerParId(UUID commande) {
        jpaUtilisateurRepository.deleteById(commande);
    }
}
