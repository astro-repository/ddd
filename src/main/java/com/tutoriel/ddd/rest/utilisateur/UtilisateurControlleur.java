//package com.tutoriel.ddd.rest.utilisateur;
//
//import com.tutoriel.ddd.core.noyaupartage.GestionnaireCommande;
//import com.tutoriel.ddd.core.noyaupartage.GestionnaireRequete;
//import com.tutoriel.ddd.core.noyaupartage.application.commande.*;
//import com.tutoriel.ddd.core.noyaupartage.application.gestionnairecommande.*;
//import com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete.GestionnaireRechercherPermission;
//import com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete.GestionnaireRechercherRole;
//import com.tutoriel.ddd.core.noyaupartage.application.gestionnairerequete.GestionnaireRechercherUtilisateur;
//import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
//import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
//import com.tutoriel.ddd.core.noyaupartage.application.port.UtilisateurRepositoryPort;
//import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
//import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
//import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Utilisateur;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api")
//public class UtilisateurControlleur {
//
//    private final GestionnaireCommande<CreerCompteCommande> gestionnaireCreerCompte;
//    private final GestionnaireCommande<CreerPermissionCommande> gestionnaireCreerPermission;
//    private final GestionnaireCommande<CreerRoleCommande> gestionnaireCreerRole;
//
//    private final GestionnaireCommande<ModifierPermissionCommande> gestionnaireModifierPermission;
//    private final GestionnaireCommande<ModifierCompteCommande> gestionnaireModifierCommande;
//    private final GestionnaireCommande<ModifierRoleCommande> gestionnaireModifierRole;
//
//    private final GestionnaireRequete<UUID, Permission> gestionnairePermissionRequete;
//    private final GestionnaireRequete<UUID, Role> gestionnaireRoleRequete;
//    private final GestionnaireRequete<UUID, Utilisateur> gestionnaireUtilisateurRequete;
//
//    private final GestionnaireCommande<UUID> supprimerPermission;
//    private final GestionnaireCommande<UUID> supprimerRole;
//    private final GestionnaireCommande<UUID> supprimerCompte;
//
//    public UtilisateurControlleur(
//            UtilisateurRepositoryPort utilisateurRepository,
//            RoleRepositoryPort roleRepository,
//            PermissionRepositoryPort permissionRepository,
//            RoleRepositoryPort roleRepositoryPort) {
//
//        supprimerCompte = new SupprimerCompteParId(utilisateurRepository);
//
//        supprimerRole = new SupprimerRoleParId(roleRepositoryPort);
//
//        supprimerPermission = new SupprimerPermissionParId(permissionRepository);
//
//        gestionnaireModifierPermission = new ModifierPermissionCommandeGestionnaire(permissionRepository);
//
//        gestionnaireModifierRole = new ModifierRoleCommandeGestionnaire(
//                roleRepositoryPort, permissionRepository);
//
//        gestionnaireUtilisateurRequete = new GestionnaireRechercherUtilisateur(
//                utilisateurRepository);
//
//        gestionnaireModifierCommande = new ModifierCompteCommandeGestionnaire(
//                utilisateurRepository);
//
//        gestionnaireRoleRequete = new GestionnaireRechercherRole(roleRepository);
//
//        gestionnairePermissionRequete = new GestionnaireRechercherPermission(
//                permissionRepository);
//
//        gestionnaireCreerPermission = new CreerPermissionCommandeGestionnaire(
//                permissionRepository);
//
//        gestionnaireCreerCompte = new CreerCompteCommandeGestionnaire(
//                utilisateurRepository, roleRepository);
//
//        gestionnaireCreerRole = new CreerRoleCommandeGestionnaire(
//                roleRepositoryPort, permissionRepository);
//
//    }
//
//    @PostMapping("/creer-compte")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void creerCompte(@RequestBody CreerCompteCommande commande) {
//
//        gestionnaireCreerCompte.execute(commande);
//
//    }
//
//    @GetMapping("/compte/{idCompte}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Utilisateur afficherComptes(@PathVariable("idCompte") UUID id) {
//
//        return gestionnaireUtilisateurRequete.requete(id);
//
//    }
//
//    @GetMapping("/comptes")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<Utilisateur> afficherListeComptes() {
//
//        return gestionnaireUtilisateurRequete.requete();
//
//    }
//
//    @PostMapping("/modifier/compte/{idCompte}")
//    @ResponseStatus(HttpStatus.OK)
//    public void modifierCompte(
//            @PathVariable(value = "idCompte", required = true) UUID id,
//            @RequestBody ModifierCompteCommande commande) {
//
//        commande.setIdUtilisateur(id);
//        gestionnaireModifierCommande.execute(commande);
//
//    }
//
//    @GetMapping("/compte/supprimer/{idCompte}")
//    @ResponseStatus(HttpStatus.OK)
//    public void supprimerCompte(
//            @PathVariable(value = "idCompte", required = true) UUID id) {
//
//        supprimerCompte.execute(id);
//
//    }
//
//    @PostMapping("/creer-permission")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void creerPermission(
//            @RequestBody CreerPermissionCommande commande) {
//
//        gestionnaireCreerPermission.execute(commande);
//
//    }
//
//    @PostMapping("/creer-permissions")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void creerPermissions(
//            @RequestBody List<CreerPermissionCommande> commandes) {
//
//        commandes.forEach(gestionnaireCreerPermission::execute);
//
//    }
//
//    @GetMapping("/permission/{idPermission}")
//    @ResponseStatus(HttpStatus.FOUND)
//    public Permission afficherPermission(
//            @PathVariable(value = "idPermission", required = true) UUID idPermission) {
//
//        return gestionnairePermissionRequete.requete(idPermission);
//
//    }
//
//    @GetMapping("/permissions")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<Permission> afficherListesPermissions() {
//
//        return gestionnairePermissionRequete.requete();
//
//    }
//
//    @PostMapping("/permission/modifier/{permissionId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void modifierPermission(
//            @PathVariable(value = "permissionId", required = true) UUID id,
//            @RequestBody ModifierPermissionCommande commande) {
//
//        commande.setId(id);
//
//        gestionnaireModifierPermission.execute(commande);
//
//    }
//
//    @GetMapping("/permission/supprimer/{supprimerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void supprimerPermission(
//            @PathVariable(value = "supprimerId", required = true) UUID id) {
//
//        supprimerPermission.execute(id);
//
//    }
//
//    @PostMapping("/creer-role")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void creerRole(@RequestBody CreerRoleCommande commande) {
//
//        gestionnaireCreerRole.execute(commande);
//
//    }
//
//    @PostMapping("/creer-roles")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void creerRoles(@RequestBody List<CreerRoleCommande> commandes) {
//
//        commandes.forEach(gestionnaireCreerRole::execute);
//
//    }
//
//    @GetMapping("/role/{roleId}")
//    @ResponseStatus(HttpStatus.FOUND)
//    public Role afficherRole(@PathVariable(value = "roleId", required = true) UUID id) {
//
//        return gestionnaireRoleRequete.requete(id);
//
//    }
//
//    @GetMapping("/roles")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<Role> listeRoles() {
//
//        return gestionnaireRoleRequete.requete();
//
//    }
//
//    @PostMapping("/role/modifier/{roleId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void modifierRole(
//            @PathVariable(value = "roleId", required = true) UUID id,
//            @RequestBody ModifierRoleCommande commande) {
//
//        commande.setId(id);
//
//        gestionnaireModifierRole.execute(commande);
//
//    }
//
//    @GetMapping("/role/supprimer/{idRole}")
//    @ResponseStatus(HttpStatus.OK)
//    public void supprimerRole(
//            @PathVariable(value = "idRole", required = true) UUID id) {
//
//        supprimerRole.execute(id);
//
//    }
//
//}
