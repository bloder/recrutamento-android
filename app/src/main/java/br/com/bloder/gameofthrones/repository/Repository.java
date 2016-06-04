package br.com.bloder.gameofthrones.repository;

import br.com.bloder.gameofthrones.repository.production.ProductionRepositoryFactory;

/**
 * Created by bloder on 04/06/16.
 */
public class Repository {

  public static RepositoryFactory get() {
    return new ProductionRepositoryFactory();
  }
}
