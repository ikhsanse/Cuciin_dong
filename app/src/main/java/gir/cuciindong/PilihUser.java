package gir.cuciindong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class PilihUser extends AppCompatActivity {

    ImageButton btn_logo_mitra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_user);

        btn_logo_mitra =  (ImageButton) findViewById(R.id.btn_logo_mitra);

        btn_logo_mitra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihUser.this, LoginMitra.class);
                startActivity(intent);
            }
        });

    }



}
