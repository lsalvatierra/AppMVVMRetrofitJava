package edu.pe.idat.appmvvmretrofitjava.apirest;

import java.util.List;

import edu.pe.idat.appmvvmretrofitjava.model.Album;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumClient {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private AlbumInterface albumInterface;
    private static AlbumClient INSTANCE;

    public AlbumClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        albumInterface = retrofit.create(AlbumInterface.class);
    }

    public static AlbumClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new AlbumClient();
        }
        return INSTANCE;
    }

    public Call<List<Album>> getAlbums(){
        return albumInterface.getAlbums();
    }
}
