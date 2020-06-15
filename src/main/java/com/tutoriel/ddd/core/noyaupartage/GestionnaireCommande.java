package com.tutoriel.ddd.core.noyaupartage;

/**
 * @param <T>
 */
public interface GestionnaireCommande<T> {

  void execute(T commande);
}
