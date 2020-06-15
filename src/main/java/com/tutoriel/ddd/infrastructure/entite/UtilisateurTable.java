package com.tutoriel.ddd.infrastructure.entite;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class UtilisateurTable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    protected UUID id;

    @Column
    protected String nom;

    @Column
    protected String prenom;

    @Column
    protected int age;

    @OneToOne(cascade = CascadeType.ALL)
    private CompteTable compteTable;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<RoleTable> rolesTable = new HashSet<>();

    public UtilisateurTable() {
    }

    public UtilisateurTable(Utilisateur utilisateur) {
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.age = utilisateur.getAge();
    }

    public UtilisateurTable(String nom , String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public CompteTable getCompteTable() {
        return compteTable;
    }

    public void setCompteTable(CompteTable compteTable) {
        this.compteTable = compteTable;
    }

    public Set<RoleTable> getRolesTable() {
        return rolesTable;
    }

    public void setRolesTable(Set<RoleTable> rolesTable) {
        this.rolesTable = rolesTable;
    }
}
