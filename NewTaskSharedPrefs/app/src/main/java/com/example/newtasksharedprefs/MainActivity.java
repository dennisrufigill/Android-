package com.example.newtasksharedprefs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Session session;

    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_logout = findViewById(R.id.id_btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(), "You clicked LoggeD Out", Toast.LENGTH_SHORT).show();

                logout();

            }
        });


        session = new Session(this);

        if (!session.loggedin()) {

            logout();
        }


    }

    private void logout() {

        session.setLoggedin(false);
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

    }
}



