package com.tutoriel.ddd.core.noyaupartage.application.commande;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
import com.tutoriel.ddd.core.noyaupartage.domaine.objetvaleur.EtatCompte;
import com.tutoriel.ddd.infrastructure.entite.RoleTable;
import com.tutoriel.ddd.infrastructure.entite.UtilisateurTable;

import javax.persistence.Column;
import java.util.*;

public class ModifierCompteCommande {

    // Utilisateur info
    private UUID idUtilisateur;
    protected String nom;
    protected String prenom;
    protected int age;
    // Compte
    protected String login;
    protected String password;
    protected EtatCompte etatCompte;
    // Role
    private Map<UUID, Role> roleMap = new HashMap<>();

    public UUID getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(UUID idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EtatCompte getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(EtatCompte etatCompte) {
        this.etatCompte = etatCompte;
    }

    public Map<UUID, Role> getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(Map<UUID, Role> roleMap) {
        this.roleMap = roleMap;
    }
}
