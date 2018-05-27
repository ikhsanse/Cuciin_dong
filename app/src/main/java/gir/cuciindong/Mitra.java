package gir.cuciindong;

/**
 * Created by Gita Diaz Pangesti on 26/05/2018.
 */

public class Mitra {

    private int id;
    private String email, password, nama_laundry, alamat_laundry, tlp_laundry;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getEmail (){
        return this.email;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public String getPassword (){
        return this.password;
    }

    public void setNama_laundry (String nama_laundry){
        this.nama_laundry = nama_laundry;
    }

    public String getNama_laundry (){
        return this.nama_laundry;
    }

    public void setAlamat_laundry (String alamat_laundry){
        this.alamat_laundry = alamat_laundry;
    }

    public String getAlamat_laundry (){
        return this.alamat_laundry;
    }

    public void setTlp_laundry (String tlp_laundry){
        this.tlp_laundry = tlp_laundry;
    }

    public String getTlp_laundry (){
        return this.tlp_laundry;
    }

}
