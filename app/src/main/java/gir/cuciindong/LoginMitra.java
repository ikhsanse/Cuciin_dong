package gir.cuciindong;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMitra extends AppCompatActivity {

    private final AppCompatActivity activity = LoginMitra.this;

    private NestedScrollView nestedScrollView;

//    private TextInputLayout textInputLayoutEmail;
//    private TextInputLayout textInputLayoutPassword;

    private EditText et_email;
    private EditText et_password;

    private Button btn_login;

    private Button btn_register_p;

    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mitra);
//        getSupportActionBar().hide();

        initViews();
        initObjects();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "SELECT password FROM akun WHERE email='" + et_email.getText().toString() + "'";
                Cursor c1 = DatabaseOpenHelper.rawQuery(query);
                String password_db;
                if (c1 != null && c1.getCount() != 0) {
                    if (c1.moveToFirst()) {
                        do {
                            password_db = c1.getString(2);
                            Toast.makeText(LoginMitra.this, "password db : " + password_db, Toast.LENGTH_SHORT).show();
                        } while (c1.moveToNext());
                    }
                }
                c1.close();
//                Toast.makeText(LoginMitra.this, "password = "+ password_db, Toast.LENGTH_SHORT).show();
//                if(et_password.getText().toString() == c1.getString(c1.getColumnIndex("password"))){
//                    Intent intent = new Intent(LoginMitra.this, HomeMitra.class);
//                    startActivity(intent);
//                }
//                if(et_password.getText().toString() != c1.getString(c1.getColumnIndex("password"))){
//                    Toast.makeText(LoginMitra.this, "Email atau password salah", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        btn_register_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMitra.this, RegisterMitra1.class);
                startActivity(intent);
            }
        });

    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        et_email = (EditText) findViewById(R.id.et_email_login_mitra);
        et_password = (EditText) findViewById(R.id.et_password_login_mitra);

        btn_login = (Button) findViewById(R.id.btn_login_mitra);

        btn_register_p = (Button) findViewById(R.id.btn_register);

    }

    /**
     * This method is to initialize listeners
     */

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_login_mitra:
//                verifyFromSQLite();
//                break;
//            case R.id.btn_register_p:
//                // Navigate to RegisterActivity
//                Intent intentRegister = new Intent(getApplicationContext(), RegisterMitra1.class);
//                startActivity(intentRegister);
//                break;
//        }
//    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
//    private void verifyFromSQLite() {
//        if (!inputValidation.isInputEditTextFilled(et_email, textInputLayoutEmail, getString(R.string.error_message_email))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextEmail(et_email, textInputLayoutEmail, getString(R.string.error_message_email))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextFilled(et_email, textInputLayoutPassword, getString(R.string.error_message_email))) {
//            return;
//        }
//
//        if (databaseHelper.checkUser(et_email.getText().toString().trim()
//                , et_password.getText().toString().trim())) {
//
//
//            Intent accountsIntent = new Intent(activity, UsersListActivity.class);
//            accountsIntent.putExtra("EMAIL", et_email.getText().toString().trim());
//            emptyInputEditText();
//            startActivity(accountsIntent);
//
//
//        } else {
//            // Snack Bar to show success message that record is wrong
//            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
//        }
//    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        et_email.setText(null);
        et_password.setText(null);
    }

}
