package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends AppCompatActivity {

    Button submit;
    EditText name, phone, email;
    DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        helper = new DatabaseHelper(this);

        submit = (Button) findViewById(R.id.button);

        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (name.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Please Insert Name", Toast.LENGTH_SHORT).show();

                }
                else if (email.getText().toString().equals("")) {


                    Toast.makeText(getApplicationContext(), "Please Insert Email", Toast.LENGTH_SHORT).show();
                }
                else if (phone.getText().toString().equals("")) {


                    Toast.makeText(getApplicationContext(), "Please Insert Phone #", Toast.LENGTH_SHORT).show();
                }


                else
                {

                    boolean result = helper.insertData(name.getText().toString(), email.getText().toString(), phone.getText().toString());

                    if (result == true) {
                        Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        phone.setText("");
                        email.setText("");
                    } else {
                        Toast.makeText(getBaseContext(), "Data insertion failed", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }


}
