package br.com.bloder.gameofthrones.values.episode;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.gameofthrones.R;

/**
 * Created by bloder on 04/06/16.
 */
@EViewGroup(R.layout.episode)
public class EpisodeViewHolder extends LinearLayout {

  @ViewById
  protected TextView title;
  @ViewById protected TextView episodeNumber;

  public EpisodeViewHolder(Context context) {
    super(context);
  }

  public void bind(Episode episode) {
    title.setText(episode.title);
    episodeNumber.setText("E" + String.valueOf(episode.number));
  }
}
