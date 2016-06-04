package br.com.bloder.gameofthrones;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
  private ProgressDialog loadingDialog;


  @AfterViews protected void afterViews() {
    showLoadingDialog();
    fetchEpisodes();
  }

  @Background protected void fetchEpisodes() {
    showEpisodes(
            Repository.get().forEpisodes().getEpisodes(),
            Repository.get().forRating().getRating()
    );
  }

  @UiThread protected void showEpisodes(List<Episode> episodes, Rating rating) {
    verifyLoadDialog();
    if(canNotLoadSeason(episodes, rating)) return;
    this.episodes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    this.episodes.setAdapter(new EpisodeAdapter(getApplicationContext(), episodes));
    this.rating.setText(String.valueOf(rating.rating).substring(0, 3));
    setupToolbarSettings();
  }

  private void showLoadingDialog() {
    loadingDialog = new ProgressDialog(this);
    loadingDialog.setMessage(getString(R.string.loading_content));
    loadingDialog.setCancelable(false);
    loadingDialog.setIndeterminate(true);
    loadingDialog.show();
  }

  private void verifyLoadDialog(){
    try {
      if (loadingDialog != null && loadingDialog.isShowing()) loadingDialog.dismiss();
    } catch (Exception ignored) {
    } finally {
      loadingDialog = null;
    }
  }

  private boolean canNotLoadSeason(List<Episode> episodes, Rating rating) {
    if((episodes == null || episodes.isEmpty()) || rating == null) {
      showErrorAndClose();
      return true;
    } else {
      return false;
    }
  }
  private void showErrorAndClose() {
    new AlertDialog.Builder(this)
            .setTitle(getString(R.string.episode_error_title))
            .setMessage(getString(R.string.episode_error_message))
            .setPositiveButton(getString(R.string.try_again_message), new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                afterViews();
              }
            })
            .setNegativeButton(getString(R.string.close), new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                finish();
              }
            })
            .setCancelable(false)
            .show();
  }

  private void setupToolbarSettings() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      toolbar.setTitle("Season 1");
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }
}
