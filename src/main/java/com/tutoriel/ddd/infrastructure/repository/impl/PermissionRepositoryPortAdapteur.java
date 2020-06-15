package com.tutoriel.ddd.infrastructure.repository.impl;

import com.tutoriel.ddd.core.noyaupartage.application.port.PermissionRepositoryPort;
import com.tutoriel.ddd.core.noyaupartage.domaine.entite.Permission;
import com.tutoriel.ddd.infrastructure.entite.PermissionTable;
import com.tutoriel.ddd.infrastructure.mapper.PermissionMappeur;
import com.tutoriel.ddd.infrastructure.repository.JpaPermissionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PermissionRepositoryPortAdapteur implements PermissionRepositoryPort {

    private final JpaPermissionRepository jpaPermissionRepository;
    private final PermissionMappeur permissionMappeur;

    public PermissionRepositoryPortAdapteur(
            JpaPermissionRepository jpaPermissionRepository,
            PermissionMappeur permissionMappeur) {

        this.jpaPermissionRepository = jpaPermissionRepository;
        this.permissionMappeur = permissionMappeur;

    }

    @Override
    public Permission rechercherParId(UUID id) {

        Optional<PermissionTable> permissionTable = jpaPermissionRepository.findById(id);
        return permissionTable.map(permissionMappeur::tableVersPermission)
                .orElse(null);

    }

    @Override
    public List<Permission> listePermission() {

        List<Permission> permissions = new ArrayList<>();
        List<PermissionTable> permissionTables = jpaPermissionRepository.findAll();

        permissionTables.forEach(permissionTable -> {
            permissions.add(permissionMappeur.tableVersPermission(permissionTable));
        });
        return permissions;

    }

    @Override
    public void creer(Permission permission) {

        PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
        jpaPermissionRepository.save(permissionTable);

    }

    @Override
    public void modifier(Permission permission) {

        PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
        permissionTable.setId(permission.getId());
        jpaPermissionRepository.save(permissionTable);

    }

    @Override
    public void supprimerParId(UUID id) {
        jpaPermissionRepository.deleteById(id);
    }

    public PermissionTable modifierR(Permission permission) {

        PermissionTable permissionTable = permissionMappeur.permissionVersTable(permission);
        permissionTable.setId(permission.getId());
        return jpaPermissionRepository.save(permissionTable);

    }
}
