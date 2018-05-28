package gir.cuciindong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterMitra1 extends AppCompatActivity {

    private Button login_p;
    private Button register_p;
    private EditText et_email;
    private EditText et_password;
    private EditText et_namaLaundry;
    private EditText et_alamatLaundry;
    private EditText et_teleponLaundry;

    private String nama_laundry;
    private String alamat_laundry;
    private String no_tlp_laundry;
    private String email;
    private String password;

    private void initializeLayout(){
        login_p =  (Button) findViewById(R.id.btn_login_p);
        register_p = (Button) findViewById(R.id.btn_register_mitra);
        et_email = (EditText) findViewById(R.id.et_email_register_mitra);
        et_password = (EditText) findViewById(R.id.et_password_register_mitra);
        et_namaLaundry = (EditText) findViewById(R.id.et_nama_register_mitra);
        et_alamatLaundry = (EditText) findViewById(R.id.et_alamat_register_mitra);
        et_teleponLaundry = (EditText) findViewById(R.id.et_telepon_register_mitra);
    }

    private void registerUser(){
        nama_laundry = et_namaLaundry.getText().toString();
        alamat_laundry = et_alamatLaundry.getText().toString();
        no_tlp_laundry = et_teleponLaundry.getText().toString();
        email = et_email.getText().toString();
        password = et_password.getText().toString();

        if(TextUtils.isEmpty(nama_laundry)){
            Toast.makeText(this, "Harap masukan nama laundry", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(alamat_laundry)){
            Toast.makeText(this, "Harap masukan alamat laundry", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(no_tlp_laundry)){
            Toast.makeText(this, "Harap masukan nomor telepon laundry", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Harap masukan email", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Harap masukan password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mitra1);

        initializeLayout();


        register_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                if (!email.isEmpty() && !password.isEmpty() && !nama_laundry.isEmpty() && !alamat_laundry.isEmpty() &&
                        !no_tlp_laundry.isEmpty()){
                    String insert_query = "INSERT INTO akun(email, password) VALUES(" +
                            "'" + email + "', " +
                            "'" + password + "')";
                    DatabaseOpenHelper.execute(insert_query);
                    Intent intent = new Intent(RegisterMitra1.this, LoginMitra.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }

            }
        });

        login_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterMitra1.this, LoginMitra.class);
                startActivity(intent);
            }
        });
    }
}
