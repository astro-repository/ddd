package com.tutoriel.ddd.infrastructure.repository;

import com.tutoriel.ddd.infrastructure.entite.PermissionTable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudPermissionRepository extends CrudRepository<PermissionTable, UUID> {
}
