package br.com.bloder.gameofthrones.repository.resources;

import java.util.List;

import br.com.bloder.gameofthrones.values.episode.Episode;

/**
 * Created by bloder on 04/06/16.
 */
public interface EpisodesRepository {

  List<Episode> getEpisodes();
}
