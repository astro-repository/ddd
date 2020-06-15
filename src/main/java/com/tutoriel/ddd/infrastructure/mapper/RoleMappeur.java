package com.tutoriel.ddd.infrastructure.mapper;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Role;
import com.tutoriel.ddd.infrastructure.entite.PermissionTable;
import com.tutoriel.ddd.infrastructure.entite.RoleTable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleMappeur {

    private final PermissionMappeur permissionMappeur;

    public RoleMappeur(PermissionMappeur permissionMappeur) {
        this.permissionMappeur = permissionMappeur;
    }

    public RoleTable roleVersTable(Role role) {

        RoleTable roleTable = new RoleTable(role);

        Set<Permission> permissions = role.getPermissions();
        Set<PermissionTable> permissionTables = new HashSet<>();
        permissions.forEach(permission -> {
            permissionTables.add(permissionMappeur.permissionVersTable(permission));
        });

        roleTable.setPermissionsTable(permissionTables);
        return roleTable;

    }

    public Role tableVersRole(RoleTable roleTable) {

        Set<PermissionTable> permissionTables = roleTable.getPermissionsTable();
        Set<Permission> permissions = new HashSet<>();
        permissionTables.forEach(permissionTable -> {
            permissions.add(permissionMappeur.tableVersPermission(permissionTable));
        });

        Role role = new Role(roleTable.getLibelle(), permissions);
        role.setId(roleTable.getId());

        return role;

    }

}
