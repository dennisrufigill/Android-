package com.example.newtasksharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_email, et_password;
    Button btn_login;
    TextView tv_register;

    Session session;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.id_et_login_email);
        et_password = findViewById(R.id.id_et_login_password);
        btn_login = findViewById(R.id.id_btn_login);
        tv_register = findViewById(R.id.id_tv_register);
        databaseHelper = new DatabaseHelper(this);

        session = new Session(this);


        if (session.loggedin()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(),"Hey", Toast.LENGTH_SHORT).show();


                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                try {
                    if (email.length() > 0 && password.length() > 0) {

                        if (databaseHelper.login(email, password)) {
                            Toast.makeText(getApplicationContext(), "Loggedin Successfull", Toast.LENGTH_SHORT).show();

                            session.setLoggedin(true);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "No.....Invalid Credentails", Toast.LENGTH_SHORT).show();
                        }

                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), " " + e, Toast.LENGTH_SHORT).show();
                }

            }
        });


        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


    }


}


