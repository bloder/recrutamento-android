package br.com.bloder.gameofthrones;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.bloder.gameofthrones.repository.Repository;
import br.com.bloder.gameofthrones.values.episode.Episode;
import br.com.bloder.gameofthrones.values.episode.EpisodeAdapter;
import br.com.bloder.gameofthrones.values.rating.Rating;

@EActivity(R.layout.episodes)
public class EpisodesActivity extends AppCompatActivity {

  @ViewById protected RecyclerView episodes;
  @ViewById protected TextView rating;

  @AfterViews protected void afterViews() {
    fetchEpisodes();
  }

  @Background protected void fetchEpisodes() {
    showEpisodes(
            Repository.get().forEpisodes().getEpisodes(),
            Repository.get().forRating().getRating()
    );
  }

  @UiThread protected void showEpisodes(List<Episode> episodes, Rating rating) {
    this.episodes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    this.episodes.setAdapter(new EpisodeAdapter(getApplicationContext(), episodes));
    this.rating.setText(String.valueOf(rating.rating).substring(0, 3));
  }
}
