package ac.id.atmaluhur.mhs.aplikasiuas;
import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class dosen2 {
    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String nama_dosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String gol_pang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String program_studi;
    public String getNidn(){
        return nidn;
    }
    public String getnama_dosen(){
        return nama_dosen;
    }
    public String getJabatan(){
        return jabatan;
    }
    public String getGol_Pang(){
        return gol_pang;
    }
    public String getKeahlian(){
        return keahlian;
    }
    public String getProgram_studi(){
        return program_studi;
    }

}
