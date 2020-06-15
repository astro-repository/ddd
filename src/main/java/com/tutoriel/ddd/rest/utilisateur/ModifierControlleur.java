package com.tutoriel.ddd.rest.utilisateur;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierCompteCommande;
import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierPermissionCommande;
import com.tutoriel.ddd.core.noyaupartage.application.commande.ModifierRoleCommande;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.ModifierCompteCommandeGestionnaire;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.ModifierPermissionCommandeGestionnaire;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.ModifierRoleCommandeGestionnaire;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/modifier")
public class ModifierControlleur {

    private final GestionnaireCommande<ModifierPermissionCommande> gestionnaireModifierPermission;
    private final GestionnaireCommande<ModifierCompteCommande> gestionnaireModifierCommande;
    private final GestionnaireCommande<ModifierRoleCommande> gestionnaireModifierRole;

    public ModifierControlleur(
            UtilisateurRepositoryPort utilisateurRepository,
            PermissionRepositoryPort permissionRepository,
            RoleRepositoryPort roleRepositoryPort) {


        gestionnaireModifierPermission = new ModifierPermissionCommandeGestionnaire(
                permissionRepository);

        gestionnaireModifierRole = new ModifierRoleCommandeGestionnaire(
                roleRepositoryPort, permissionRepository);

        gestionnaireModifierCommande = new ModifierCompteCommandeGestionnaire(
                utilisateurRepository);

    }

    @PostMapping("/compte/{idCompte}")
    @ResponseStatus(HttpStatus.OK)
    public void modifierCompte(
            @PathVariable(value = "idCompte", required = true) UUID id,
            @RequestBody ModifierCompteCommande commande) {

        commande.setIdUtilisateur(id);
        gestionnaireModifierCommande.execute(commande);

    }

    @PostMapping("/permission/{permissionId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifierPermission(
            @PathVariable(value = "permissionId", required = true) UUID id,
            @RequestBody ModifierPermissionCommande commande) {

        commande.setId(id);
        gestionnaireModifierPermission.execute(commande);

    }

    @PostMapping("/role/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifierRole(
            @PathVariable(value = "roleId", required = true) UUID id,
            @RequestBody ModifierRoleCommande commande) {

        commande.setId(id);
        gestionnaireModifierRole.execute(commande);

    }

}
