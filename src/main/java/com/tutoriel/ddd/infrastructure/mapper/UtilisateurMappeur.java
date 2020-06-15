package com.tutoriel.ddd.infrastructure.mapper;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Compte;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;
import com.tutoriel.ddd.infrastructure.entite.CompteTable;
import com.tutoriel.ddd.infrastructure.entite.RoleTable;
import com.tutoriel.ddd.infrastructure.entite.UtilisateurTable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UtilisateurMappeur {

    private final CompteMappeur compteMappeur;
    private final RoleMappeur roleMappeur;

    public UtilisateurMappeur(CompteMappeur compteMappeur, RoleMappeur roleMappeur) {
        this.compteMappeur = compteMappeur;
        this.roleMappeur = roleMappeur;
    }

    public UtilisateurTable utilisateurVersUtilisateurTable(Utilisateur utilisateur) {

        UtilisateurTable utilisateurTable = new UtilisateurTable(utilisateur);

        Compte compte = utilisateur.getCompte();
        CompteTable compteTable = compteMappeur.compteVersTable(compte);
        utilisateurTable.setCompteTable(compteTable);

        Set<Role> roles = utilisateur.getRoles();
        Set<RoleTable> roleTables = new HashSet<>();
        roles.forEach(role -> roleTables.add(roleMappeur.roleVersTable(role)));
        utilisateurTable.setRolesTable(roleTables);

        // TODO : Convertisseur des autres tables
        return utilisateurTable;

    }

    public Utilisateur utilisateurTableVersUtilisateur(UtilisateurTable table) {

        Utilisateur utilisateur = new Utilisateur(
                table.getNom(),
                table.getPrenom(),
                table.getAge()
        );

        utilisateur.setId(table.getId());
        Set<Role> roles = new HashSet<>();
        table.getRolesTable().forEach(roleTable -> {
            roles.add(roleMappeur.tableVersRole(roleTable));
        });
        utilisateur.setRoles(roles);
        utilisateur.setCompte(compteMappeur.tableVersCompte(table.getCompteTable()));

        return utilisateur;
        // TODO : Convertisseur des autres tables

    }

}
