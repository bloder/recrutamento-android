package br.com.bloder.gameofthrones.api.payloads;

import com.google.gson.annotations.SerializedName;

import br.com.bloder.gameofthrones.values.rating.Rating;

/**
 * Created by bloder on 04/06/16.
 */
public class RatingPayload {

  @SerializedName("rating") private final double rating;

  public RatingPayload(double rating) {
    this.rating = rating;
  }

  public Rating toRating() {
    return new Rating(this.rating);
  }
}
