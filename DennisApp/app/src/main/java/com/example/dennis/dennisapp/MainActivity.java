package com.example.dennis.dennisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView newuser;
    EditText name,email,password,cpassword;
    Button login,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newuser = (TextView) findViewById(R.id.tv);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancel);


        email.setVisibility(View.GONE);
        cpassword.setVisibility(View.GONE);

cancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        name.setText("");
        password.setText("");
        email.setText("");
        cpassword.setText("");
    }
});


       newuser.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(newuser.getText()=="Already User")
               {
                   cpassword.setVisibility(View.GONE);
                   email.setVisibility(View.GONE);
                   newuser.setText("New User");
                   login.setText("LOGIN");
               }
               else {

                   cpassword.setVisibility(View.VISIBLE);
                   email.setVisibility(View.VISIBLE);
                   newuser.setText("Already User");
                   login.setText("Sign Up");


               }
           }
       });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(i);
            }
        });

    }
}
