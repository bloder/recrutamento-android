package br.com.bloder.gameofthrones.repository;

import br.com.bloder.gameofthrones.repository.resources.EpisodesRepository;
import br.com.bloder.gameofthrones.repository.resources.RatingRepository;

/**
 * Created by bloder on 04/06/16.
 */
public interface RepositoryFactory {

  EpisodesRepository forEpisodes();
  RatingRepository forRating();
}
