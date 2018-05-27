package gir.cuciindong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RegisterMitra1 extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mitra1);
    }
    public void onSignUpClick (View v){
        if (v.getId() == R.id.btn_register_mitra){
            EditText et_email = (EditText) findViewById(R.id.et_email_register_mitra);
            EditText et_password = (EditText) findViewById(R.id.et_password_register_mitra);
            EditText et_namaLaundry = (EditText) findViewById(R.id.et_nama_register_mitra);
            EditText et_alamatLaundry = (EditText) findViewById(R.id.et_alamat_register_mitra);
            EditText et_teleponLaundry = (EditText) findViewById(R.id.et_telepon_register_mitra);

            String nama_laundry = et_namaLaundry.getText().toString();
            String alamat_laundry = et_alamatLaundry.getText().toString();
            String no_tlp_laundry = et_teleponLaundry.getText().toString();
            String email = et_email.getText().toString();
            String password = et_password.getText().toString();

            Mitra c = new Mitra();
            c.setEmail(email);
            c.setPassword(password);
            c.setNama_laundry(nama_laundry);
            c.setAlamat_laundry(alamat_laundry);
            c.setTlp_laundry(no_tlp_laundry);
			
			//jago lu bre
            helper.insertContact(c);






        }
    }

}
