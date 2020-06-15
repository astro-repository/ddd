package com.tutoriel.ddd.infrastructure.repository;

import com.tutoriel.ddd.infrastructure.entite.UtilisateurTable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudUtilisateurRepository extends CrudRepository<UtilisateurTable, UUID> {
}
