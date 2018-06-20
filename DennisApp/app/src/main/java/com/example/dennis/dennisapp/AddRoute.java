package com.example.dennis.dennisapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Dennis on 9/22/2016.
 */
public class AddRoute extends AppCompatActivity{

    EditText routeid, routeto, routefrom;
    Button   save, cancel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_route);

        routeid = (EditText) findViewById(R.id.rid);
        routefrom = (EditText) findViewById(R.id.rfrom);
        routeto = (EditText) findViewById(R.id.rto);

        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routeid.setText("");
                routefrom.setText("");
                routeto.setText("");

            }
        });


    }
}
