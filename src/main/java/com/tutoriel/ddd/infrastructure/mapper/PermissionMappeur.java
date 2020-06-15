package com.tutoriel.ddd.infrastructure.mapper;

import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
import com.tutoriel.ddd.infrastructure.entite.PermissionTable;
import org.springframework.stereotype.Service;

@Service
public class PermissionMappeur {

    public PermissionTable permissionVersTable(Permission permission) {
        return new PermissionTable(permission);
    }

    public Permission tableVersPermission(PermissionTable table) {
        
        Permission permission = new Permission(
                table.getLibelle(),
                table.getDescription()
        );
        permission.setId(table.getId());

        return permission;
    }

}
