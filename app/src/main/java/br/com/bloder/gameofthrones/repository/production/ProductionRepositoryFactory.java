package br.com.bloder.gameofthrones.repository.production;

import br.com.bloder.gameofthrones.repository.RepositoryFactory;
import br.com.bloder.gameofthrones.repository.resources.EpisodesRepository;
import br.com.bloder.gameofthrones.repository.resources.RatingRepository;

/**
 * Created by bloder on 04/06/16.
 */
public class ProductionRepositoryFactory implements RepositoryFactory {
  
  @Override
  public EpisodesRepository forEpisodes() {
    return null;
  }

  @Override
  public RatingRepository forRating() {
    return null;
  }
}
