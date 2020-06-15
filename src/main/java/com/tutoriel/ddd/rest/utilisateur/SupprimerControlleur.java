package com.tutoriel.ddd.rest.utilisateur;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.SupprimerCompteParId;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.SupprimerPermissionParId;
import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.SupprimerRoleParId;
import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/supprimer/")
public class SupprimerControlleur {

    private final GestionnaireCommande<UUID> supprimerPermission;
    private final GestionnaireCommande<UUID> supprimerRole;
    private final GestionnaireCommande<UUID> supprimerCompte;

    public SupprimerControlleur(
            UtilisateurRepositoryPort utilisateurRepository,
            PermissionRepositoryPort permissionRepository,
            RoleRepositoryPort roleRepositoryPort) {

        supprimerCompte = new SupprimerCompteParId(utilisateurRepository);

        supprimerRole = new SupprimerRoleParId(roleRepositoryPort);

        supprimerPermission = new SupprimerPermissionParId(permissionRepository);

    }

    @GetMapping("/compte/{idCompte}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerCompte(
            @PathVariable(value = "idCompte", required = true) UUID id) {

        supprimerCompte.execute(id);

    }

    @GetMapping("/permission/{supprimerId}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerPermission(
            @PathVariable(value = "supprimerId", required = true) UUID id) {

        supprimerPermission.execute(id);

    }

    @GetMapping("/role/{idRole}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerRole(
            @PathVariable(value = "idRole", required = true) UUID id) {

        supprimerRole.execute(id);

    }

}
