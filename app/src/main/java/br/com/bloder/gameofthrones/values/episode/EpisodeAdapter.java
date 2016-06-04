package br.com.bloder.gameofthrones.values.episode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bloder on 04/06/16.
 */
public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.InternalViewHolder> {

  private Context context;
  private List<Episode> episodes;

  public EpisodeAdapter(Context context, List<Episode> episodes) {
    this.context = context;
    this.episodes = episodes;
  }

  @Override
  public InternalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new InternalViewHolder();
  }

  @Override
  public void onBindViewHolder(InternalViewHolder holder, int position) {
    holder.bind(this.episodes.get(position));
  }

  @Override
  public int getItemCount() {
    return episodes.size();
  }

  public class InternalViewHolder extends RecyclerView.ViewHolder {
    public InternalViewHolder() {
      super(EpisodeViewHolder_.build(context));
    }

    public void bind(Episode episode) {
      ((EpisodeViewHolder) this.itemView).bind(episode);
    }
  }
}
