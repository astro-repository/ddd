package com.tutoriel.ddd.rest.utilisateur;

import com.tutoriel.ddd.core.noyaupartage.GestionnaireRequete;
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
@RequestMapping("/api/afficher/")
public class afficherControlleur {

    private final GestionnaireRequete<UUID, Permission> gestionnairePermissionRequete;
    private final GestionnaireRequete<UUID, Role> gestionnaireRoleRequete;
    private final GestionnaireRequete<UUID, Utilisateur> gestionnaireUtilisateurRequete;

    public afficherControlleur(
            UtilisateurRepositoryPort utilisateurRepository,
            RoleRepositoryPort roleRepository,
            PermissionRepositoryPort permissionRepository) {

        gestionnaireUtilisateurRequete = new GestionnaireRechercherUtilisateur(
                utilisateurRepository);

        gestionnaireRoleRequete = new GestionnaireRechercherRole(roleRepository);

        gestionnairePermissionRequete = new GestionnaireRechercherPermission(
                permissionRepository);
    }

    @GetMapping("/compte/{idCompte}")
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateur afficherComptes(@PathVariable("idCompte") UUID id) {

        return gestionnaireUtilisateurRequete.requete(id);

    }

    @GetMapping("/comptes")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Utilisateur> afficherListeComptes() {

        return gestionnaireUtilisateurRequete.requete();

    }

    @GetMapping("/permission/{idPermission}")
    @ResponseStatus(HttpStatus.FOUND)
    public Permission afficherPermission(
            @PathVariable(value = "idPermission", required = true) UUID idPermission) {

        return gestionnairePermissionRequete.requete(idPermission);

    }

    @GetMapping("/permissions")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Permission> afficherListesPermissions() {

        return gestionnairePermissionRequete.requete();

    }

    @GetMapping("/role/{roleId}")
    @ResponseStatus(HttpStatus.FOUND)
    public Role afficherRole(@PathVariable(value = "roleId", required = true) UUID id) {

        return gestionnaireRoleRequete.requete(id);

    }

    @GetMapping("/roles")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Role> listeRoles() {

        return gestionnaireRoleRequete.requete();

    }

}
