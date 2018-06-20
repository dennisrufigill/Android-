package com.example.dennis.dennisapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Dennis on 9/22/2016.
 */
public class AddBus extends AppCompatActivity {

    EditText bnp, busroute, busdriver, busid;

    Button save,cancel;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bus);

        bnp = (EditText) findViewById(R.id.bnp);
        busroute = (EditText) findViewById(R.id.broute);
        busdriver = (EditText) findViewById(R.id.bdriver);
        busid = (EditText) findViewById(R.id.busid);

               save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);


cancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        bnp.setText("");
        busroute.setText("");
        busdriver.setText("");
        busid.setText("");

    }
});











    }
}
