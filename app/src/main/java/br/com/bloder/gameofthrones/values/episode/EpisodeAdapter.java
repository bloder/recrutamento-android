package br.com.bloder.gameofthrones.values.episode;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bloder on 04/06/16.
 */
public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.InternalViewHolder> {


  @Override
  public InternalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(InternalViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  public class InternalViewHolder extends RecyclerView.ViewHolder {
    public InternalViewHolder(View itemView) {
      super(itemView);
    }
  }
}
