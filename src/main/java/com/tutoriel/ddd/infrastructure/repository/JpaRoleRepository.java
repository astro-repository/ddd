package com.tutoriel.ddd.infrastructure.repository;

import com.tutoriel.ddd.infrastructure.entite.RoleTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRoleRepository extends JpaRepository<RoleTable, UUID> {
    RoleTable findRoleTableById(UUID id);
}
