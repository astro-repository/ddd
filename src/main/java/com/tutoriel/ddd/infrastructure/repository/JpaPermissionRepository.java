package com.tutoriel.ddd.infrastructure.repository;

import com.tutoriel.ddd.infrastructure.entite.PermissionTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPermissionRepository extends JpaRepository<PermissionTable, UUID> {
    PermissionTable getPermissionTableById(UUID id);
}
