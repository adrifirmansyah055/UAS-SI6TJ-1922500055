package ac.id.atmaluhur.mhs.aplikasiuas;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import java.util.HashMap;
public class EDosen extends AppCompatActivity {
    private EditText text_nidn,text_nama_dosen,text_jabatan,text_gol_pang,text_keahlian,text_prodi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edosen);

        text_nidn = (EditText) findViewById(R.id.text_nidn);
        text_nama_dosen = (EditText) findViewById(R.id.text_nama_dosen);
        text_jabatan = (EditText) findViewById(R.id.text_jabatan);
        text_gol_pang = (EditText) findViewById(R.id.text_gol_pang);
        text_keahlian = (EditText) findViewById(R.id.text_keahlian);
        text_prodi = (EditText) findViewById(R.id.text_program_studi);
    }

    public void tambahData(View View){
        final String nidn = text_nidn.getText().toString().trim();
        final String nama_dosen = text_nama_dosen.getText().toString().trim();
        final String jabatan = text_jabatan.getText().toString().trim();
        final String gol_pang = text_gol_pang.getText().toString().trim();
        final String keahlian = text_keahlian.getText().toString().trim();
        final String program_studi = text_prodi.getText().toString().trim();

        class tambahDosen extends AsyncTask<Void, Void, String>{
            ProgressDialog load;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                load = ProgressDialog.show(
                        EDosen.this, "Add...","Wait...",false,false );
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put("nidn",nidn);
                params.put("nama_dosen",nama_dosen);
                params.put("jabatan", jabatan);
                params.put("gol_pang",gol_pang);
                params.put("keahlian",keahlian);
                params.put("program_studi",program_studi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.100.188/Api/tambah_dtDosen.php",params);
                return res;
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                load.dismiss();
                Toast.makeText(EDosen.this,s,Toast.LENGTH_LONG).show();
            }
        }
        tambahDosen tambah = new tambahDosen();
        tambah.execute();
    }
}