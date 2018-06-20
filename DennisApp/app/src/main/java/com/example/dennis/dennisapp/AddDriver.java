package com.example.dennis.dennisapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dennis.dennisapp.com.example.dennis.database.DriverBean;

/**
 * Created by Dennis on 9/22/2016.
 */
public class AddDriver extends AppCompatActivity{


    EditText drivername, drivercontact, driverroute, driverid;
    Button save, cancel;

    DriverBean dri = new DriverBean();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_driver);

        drivername = (EditText) findViewById(R.id.dname);
        drivercontact = (EditText) findViewById(R.id.dcn);
        driverroute = (EditText) findViewById(R.id.droute);
        driverid = (EditText) findViewById(R.id.did);

        save=(Button) findViewById(R.id.save);
        cancel=(Button) findViewById(R.id.cancel);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drivername.setText("");
                drivercontact.setText("");
                driverid.setText("");
                driverroute.setText("");
            }
        });






    }

}
