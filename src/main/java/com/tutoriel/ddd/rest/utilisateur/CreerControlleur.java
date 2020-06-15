package com.tutoriel.ddd.rest.utilisateur;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.GestionnaireRequete;
import com.tutoriel.ddd.core.noyaupartage.application.commande.*;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.*;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete.GestionnaireRechercherPermission;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete.GestionnaireRechercherRole;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete.GestionnaireRechercherUtilisateur;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/creer/")
public class CreerControlleur {

    private final GestionnaireCommande<CreerCompteCommande> gestionnaireCreerCompte;
    private final GestionnaireCommande<CreerPermissionCommande> gestionnaireCreerPermission;
    private final GestionnaireCommande<CreerRoleCommande> gestionnaireCreerRole;

    public CreerControlleur(
            UtilisateurRepositoryPort utilisateurRepository,
            RoleRepositoryPort roleRepository,
            PermissionRepositoryPort permissionRepository,
            RoleRepositoryPort roleRepositoryPort) {

        gestionnaireCreerPermission = new CreerPermissionCommandeGestionnaire(
                permissionRepository);

        gestionnaireCreerCompte = new CreerCompteCommandeGestionnaire(
                utilisateurRepository, roleRepository);

        gestionnaireCreerRole = new CreerRoleCommandeGestionnaire(
                roleRepositoryPort, permissionRepository);

    }

    @PostMapping("/compte")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerCompte(@RequestBody CreerCompteCommande commande) {

        gestionnaireCreerCompte.execute(commande);

    }

    @PostMapping("/permission")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerPermission(
            @RequestBody CreerPermissionCommande commande) {

        gestionnaireCreerPermission.execute(commande);

    }

    @PostMapping("/permissions")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerPermissions(
            @RequestBody List<CreerPermissionCommande> commandes) {

        commandes.forEach(gestionnaireCreerPermission::execute);

    }

    @PostMapping("/role")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerRole(@RequestBody CreerRoleCommande commande) {

        gestionnaireCreerRole.execute(commande);

    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void creerRoles(@RequestBody List<CreerRoleCommande> commandes) {

        commandes.forEach(gestionnaireCreerRole::execute);

    }

}
