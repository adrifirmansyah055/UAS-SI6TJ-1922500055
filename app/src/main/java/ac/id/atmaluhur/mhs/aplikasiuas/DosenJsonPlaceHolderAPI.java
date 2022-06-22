package ac.id.atmaluhur.mhs.aplikasiuas;

import java.util.List;
        import retrofit2.http.GET;
        import java.util.Map;
        import retrofit2.Call;
        import retrofit2.http.QueryMap;
public interface DosenJsonPlaceHolderAPI {
    @GET("dosen.php")
    Call<List<dosen2>> getPosts(

    );
    @GET("dosen.php")
    Call<List<dosen2>> getPosts(@QueryMap Map<String,String> parameters);
}
