package com.tutoriel.ddd.infrastructure.repository;

import com.tutoriel.ddd.infrastructure.entite.CompteTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCompteRepository extends JpaRepository<CompteTable, UUID> {
}
