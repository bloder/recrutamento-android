package br.com.bloder.gameofthrones.repository.production;

import br.com.bloder.gameofthrones.api.TraktApi;
import br.com.bloder.gameofthrones.repository.resources.RatingRepository;
import br.com.bloder.gameofthrones.values.rating.Rating;
import retrofit.RetrofitError;

/**
 * Created by bloder on 04/06/16.
 */
public class ProductionRatingRepository implements RatingRepository {

  @Override
  public Rating getRating() {
    try {
      return TraktApi.getServices().getRating().toRating();
    } catch (RetrofitError ignored) {
      return null;
    }
  }
}
