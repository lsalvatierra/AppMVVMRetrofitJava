package edu.pe.idat.appmvvmretrofitjava.apirest;

import java.util.List;

import edu.pe.idat.appmvvmretrofitjava.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumInterface {

    @GET("albums")
    public Call<List<Album>> getAlbums();
}
