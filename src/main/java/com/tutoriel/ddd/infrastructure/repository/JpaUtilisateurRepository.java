package com.tutoriel.ddd.infrastructure.repository;

import com.tutoriel.ddd.infrastructure.entite.UtilisateurTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public interface JpaUtilisateurRepository extends JpaRepository<UtilisateurTable, UUID> {

    @Modifying
    @Transactional
    @Query("update UtilisateurTable user set user.nom=:nom, user.prenom=:prenom, user.age=:age, user.compteTable.login=:loginCompte, user.compteTable.password=:passwordCompte where user.id=:idUtilisateur")
    void modifier(@Param("idUtilisateur") UUID id,
                  @Param("nom") String nom,
                  @Param("prenom") String prenom,
                  @Param("age") int age,
                  @Param("loginCompte") String login,
                  @Param("passwordCompte") String password);
}
