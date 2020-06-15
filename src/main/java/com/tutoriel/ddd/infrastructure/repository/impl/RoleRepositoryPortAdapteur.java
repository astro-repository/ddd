package com.tutoriel.ddd.infrastructure.repository.impl;

import com.tutoriel.ddd.core.noyaupartage.application.port.RoleRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
import com.tutoriel.ddd.infrastructure.entite.PermissionTable;
import com.tutoriel.ddd.infrastructure.entite.RoleTable;
import com.tutoriel.ddd.infrastructure.mapper.PermissionMappeur;
import com.tutoriel.ddd.infrastructure.mapper.RoleMappeur;
import com.tutoriel.ddd.infrastructure.repository.JpaRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoleRepositoryPortAdapteur implements RoleRepositoryPort {

    private final JpaRoleRepository jpaRoleRepository;
    private final RoleMappeur roleMappeur;
    private final PermissionMappeur permissionMappeur;

    public RoleRepositoryPortAdapteur(JpaRoleRepository jpaRoleRepository, RoleMappeur roleMappeur, PermissionMappeur permissionMappeur) {
        this.jpaRoleRepository = jpaRoleRepository;
        this.roleMappeur = roleMappeur;
        this.permissionMappeur = permissionMappeur;
    }

    @Override
    public Role rechercherRoleParId(UUID roleId) {
        Optional<RoleTable> roleTable = jpaRoleRepository.findById(roleId);

        return roleTable.map(roleMappeur::tableVersRole).orElse(null);
    }

    @Override
    public List<Role> listeRole() {

        List<Role> roles = new ArrayList<>();
        List<RoleTable> roleTables = jpaRoleRepository.findAll();
        roleTables.forEach(roleTable -> {
            System.out.println(roleTable.getPermissionsTable());
            roles.add(roleMappeur.tableVersRole(roleTable));
        });

        return roles;
    }

    @Override
    public void creer(Role role) {
        RoleTable roleTable = roleMappeur.roleVersTable(role);
        jpaRoleRepository.save(roleTable);
    }

    @Override
    public void modifier(Role role) {

        RoleTable roleTable = roleMappeur.roleVersTable(role);
        roleTable.setId(role.getId());

        Set<PermissionTable> permissionTables = new HashSet<>();

        role.getPermissions().forEach(permission -> {
            PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
            permissionTable.setId(permission.getId());
            permissionTables.add(permissionTable);
        });

        roleTable.setPermissionsTable(permissionTables);

        jpaRoleRepository.save(roleTable);

    }

    @Override
    public void supprimerParId(UUID commande) {
        jpaRoleRepository.deleteById(commande);
    }
}
