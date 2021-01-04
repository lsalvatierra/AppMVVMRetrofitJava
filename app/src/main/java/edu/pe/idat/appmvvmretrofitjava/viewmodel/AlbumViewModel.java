package edu.pe.idat.appmvvmretrofitjava.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.pe.idat.appmvvmretrofitjava.apirest.AlbumClient;
import edu.pe.idat.appmvvmretrofitjava.model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumViewModel extends AndroidViewModel {
    public MutableLiveData<List<Album>> albumsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> albums = new MutableLiveData<>();

    public AlbumViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAlbums() {
        AlbumClient.getINSTANCE().getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                albumsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                albums.setValue("errr");
            }
        });
    }
}
