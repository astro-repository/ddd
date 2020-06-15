package com.tutoriel.ddd.core.noyaupartage;

import java.util.List;

/**
 *
 */
public interface GestionnaireRequete<C,R> {

  R requete(C critere);
  List<R> requete();
}
