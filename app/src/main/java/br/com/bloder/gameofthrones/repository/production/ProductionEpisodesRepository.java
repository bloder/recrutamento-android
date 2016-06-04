package br.com.bloder.gameofthrones.repository.production;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.gameofthrones.api.TraktApi;
import br.com.bloder.gameofthrones.api.payloads.EpisodePayload;
import br.com.bloder.gameofthrones.repository.resources.EpisodesRepository;
import br.com.bloder.gameofthrones.values.episode.Episode;
import retrofit.RetrofitError;

/**
 * Created by bloder on 04/06/16.
 */
public class ProductionEpisodesRepository implements EpisodesRepository {

  @Override
  public List<Episode> getEpisodes() {
    try {
      return toEpisodes(TraktApi.getServices().getEpisodes());
    } catch (RetrofitError ignored) {
      return new ArrayList<>();
    }
  }

  public List<Episode> toEpisodes(List<EpisodePayload> episodePayloads) {
    List<Episode> episodes = new ArrayList<>();

    for(EpisodePayload episodePayload : episodePayloads) {
      episodes.add(episodePayload.toEpisode());
    }
    return episodes;
  }
}
