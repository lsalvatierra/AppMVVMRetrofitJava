package edu.pe.idat.appmvvmretrofitjava.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.pe.idat.appmvvmretrofitjava.R;
import edu.pe.idat.appmvvmretrofitjava.model.Album;
import edu.pe.idat.appmvvmretrofitjava.viewmodel.AlbumViewModel;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

    private List<Album> albumsList = new ArrayList<>();

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlbumAdapter.ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_album, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        holder.tvid.setText(albumsList.get(position).getId().toString());
        holder.tvtitulo.setText(albumsList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return albumsList.size();
    }

    public void setList(List<Album> lista) {
        this.albumsList = lista;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvid, tvtitulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tvid);
            tvtitulo = itemView.findViewById(R.id.tvtitulo);
        }
    }
}
