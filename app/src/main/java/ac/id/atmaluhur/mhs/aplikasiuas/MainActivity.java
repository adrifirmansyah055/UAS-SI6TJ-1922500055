package ac.id.atmaluhur.mhs.aplikasiuas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public TextView textViewResult;
    private DosenJsonPlaceHolderAPI jsonPlaceHolderAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_viewData);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.188/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderAPI = retrofit.create(DosenJsonPlaceHolderAPI.class);
        getPosts();
    }

    private void getPosts(){
        Map<String, String> parameters = new HashMap<>();
        Call<List<dosen2>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<dosen2>>() {
            @Override
            public void onResponse(Call<List<dosen2>> call, Response<List<dosen2>> response){
                if(!response.isSuccessful()){
                    textViewResult.setText("code: "+ response.code());
                    return;
                }
                List<dosen2> posts = response.body();
                for (dosen2 post:posts){
                    String content = "";
                    content += "nidn: " +post.getNidn() + "\n";
                    content += "nama_dosen: " +post.getnama_dosen() + "\n";
                    content += "jabatan: " +post.getJabatan() + "\n";
                    content += "gol_pang: " +post.getGol_Pang() + "\n";
                    content += "keahlian: " +post.getKeahlian() + "\n";
                    content += "program_studi: " +post.getProgram_studi() + "\n\n";
                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<dosen2>> call, Throwable t){
                textViewResult.setText(t.getMessage());
            }
        });
    }
    public void formTambah(View View){
        Intent i = new Intent(MainActivity.this,EDosen.class);
        startActivity(i);
    }

}