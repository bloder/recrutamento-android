package br.com.bloder.gameofthrones.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.bloder.gameofthrones.BuildConfig;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by bloder on 04/06/16.
 */
public class TraktApi {

  public static TraktServices getServices() {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    RestAdapter retrofit = new RestAdapter.Builder()
            .setEndpoint(BuildConfig.END_POINT)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setConverter(new GsonConverter(gson))
            .build();

    return retrofit.create(TraktServices.class);
  }
}
