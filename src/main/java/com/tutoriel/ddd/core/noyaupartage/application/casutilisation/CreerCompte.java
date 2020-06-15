package com.tutoriel.ddd.core.noyaupartage.application.casutilisation;

import com.tutoriel.ddd.core.noyaupartage.application.commande.CreerCompteCommande;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Compte;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>Cas d'utilisation pour la création d'un utilisateur et de son compte.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public class CreerCompte {

    private final UtilisateurRepositoryPort utilisateurPortRepository;
    private final RoleRepositoryPort roleRepositoryPort;

    public CreerCompte(
            UtilisateurRepositoryPort utilisateurPortRepository,
            RoleRepositoryPort roleRepositoryPort) {

        this.utilisateurPortRepository = utilisateurPortRepository;
        this.roleRepositoryPort = roleRepositoryPort;
    }

    public void cree(CreerCompteCommande commande) {

        String nom = commande.getNom();
        String prenom = commande.getPrenom();
        int age = commande.getAge();

        Utilisateur utilisateur = new Utilisateur(nom, prenom, age);
        List<UUID> rolesId = commande.getRolesId();
        List<Role> roles = rolesId.stream()
                .map(roleRepositoryPort::rechercherRoleParId)
                .collect(Collectors.toList());
        for (Role role : roles) {
            utilisateur.ajouterRole(role);
        }

        String login = commande.getLogin();
        String password = commande.getPassword();
        Compte compte = utilisateur.creerCompte(login, password);

        utilisateurPortRepository.enregistrer(utilisateur);

    }
}
