package com.example.retrofitpostabhiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SignUpResponse signUpResponseData;
    EditText name, emailId, password;
    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.username);
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUp);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate(name) && validateEmail() && validate(password)) {

                    signUp();
                }
            }
        });
    }

    private boolean validate(EditText editText) {

        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }

        editText.setError("Please fill in");
        editText.requestFocus();
        return false;


    }

    private boolean validateEmail() {

        String email = emailId.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            emailId.setError("Email is not Valid");
            emailId.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {

        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }

    public void signUp(){

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                            progressDialog.setCancelable(false);
                            progressDialog.setMessage("Please Wait");
                            progressDialog.show();

        (Api.getClient().registration(name.getText().toString().trim(),
                emailId.getText().toString().trim(),
                password.getText().toString().trim(),
                "email")).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                signUpResponseData = response.body();
                Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                Log.d("response", t.getStackTrace().toString());
                progressDialog.dismiss();

            }
        });

    }


}
