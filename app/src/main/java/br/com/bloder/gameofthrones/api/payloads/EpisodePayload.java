package br.com.bloder.gameofthrones.api.payloads;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bloder on 04/06/16.
 */
public class EpisodePayload {

  @SerializedName("number") private final int number;
  @SerializedName("title") private final String title;

  public EpisodePayload(int number, String title) {
    this.number = number;
    this.title = title;
  }
}
