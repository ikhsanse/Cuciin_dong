package gir.cuciindong;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class LoginMitra extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = LoginMitra.this;

    private NestedScrollView nestedScrollView;

//    private TextInputLayout textInputLayoutEmail;
//    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText et_email;
    private TextInputEditText et_password;

    private AppCompatButton btn_login;

    private AppCompatTextView btn_register_p;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mitra);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        et_email = (TextInputEditText) findViewById(R.id.et_email_login_mitra);
        et_password = (TextInputEditText) findViewById(R.id.et_password_login_mitra);

        btn_login = (AppCompatButton) findViewById(R.id.btn_login_mitra);

        btn_register_p = (AppCompatTextView) findViewById(R.id.btn_register_p);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        btn_login.setOnClickListener(this);
        btn_register_p.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_mitra:
                verifyFromSQLite();
                break;
            case R.id.btn_register_p:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterMitra1.class);
                startActivity(intentRegister);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(et_email, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(et_email, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(et_email, textInputLayoutPassword, getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(et_email.getText().toString().trim()
                , et_password.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, UsersListActivity.class);
            accountsIntent.putExtra("EMAIL", et_email.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        et_email.setText(null);
        et_password.setText(null);
    }

}
