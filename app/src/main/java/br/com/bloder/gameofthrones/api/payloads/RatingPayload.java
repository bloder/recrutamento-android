package br.com.bloder.gameofthrones.api.payloads;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bloder on 04/06/16.
 */
public class RatingPayload {

  @SerializedName("rating") private final double rating;

  public RatingPayload(double rating) {
    this.rating = rating;
  }
}
