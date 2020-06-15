package com.tutoriel.ddd.core.noyaupartage.application.port;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;

import java.util.List;
import java.util.UUID;

/**
 * <p>Interface pour le port du repository de l'entité {@link Role}.</p>
 *
 * @author Christian Amani 2020-05-27
 */
public interface RoleRepositoryPort {

    Role rechercherRoleParId(UUID roleId);

    List<Role> listeRole();

    void creer(Role role);

    void modifier(Role role);

    void supprimerParId(UUID commande);
}
