package edu.pe.idat.appmvvmretrofitjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import edu.pe.idat.appmvvmretrofitjava.R;
import edu.pe.idat.appmvvmretrofitjava.model.Album;
import edu.pe.idat.appmvvmretrofitjava.ui.adapters.AlbumAdapter;
import edu.pe.idat.appmvvmretrofitjava.viewmodel.AlbumViewModel;

public class MainActivity extends AppCompatActivity {

    AlbumViewModel albumViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        albumViewModel = new ViewModelProvider(this).get(AlbumViewModel.class);

        albumViewModel.getAlbums();
        RecyclerView recyclerView = findViewById(R.id.rvalbums);
        final AlbumAdapter adapter = new AlbumAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        albumViewModel.albumsMutableLiveData.observe(this,
                new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsModels) {
                adapter.setList(albumsModels);
            }
        });
    }
}