package br.com.bloder.gameofthrones.api;

import java.util.List;

import br.com.bloder.gameofthrones.BuildConfig;
import br.com.bloder.gameofthrones.api.payloads.EpisodePayload;
import br.com.bloder.gameofthrones.api.payloads.RatingPayload;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by bloder on 04/06/16.
 */
public interface TraktServices {

  @Headers({"Content-Type: application/json", "trakt-api-version:2", "trakt-api-key:"+ BuildConfig.TRAKT_ID})
  @GET("/game-of-thrones/seasons/1")
  List<EpisodePayload> getEpisodes();

  @Headers({"Content-Type: application/json", "trakt-api-version:2", "trakt-api-key:"+ BuildConfig.TRAKT_ID})
  @GET("/game-of-thrones/ratings")
  RatingPayload getRating();
}
