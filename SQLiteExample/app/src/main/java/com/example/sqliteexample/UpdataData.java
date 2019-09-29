package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdataData extends AppCompatActivity {

    DatabaseHelper helper;
    EditText id, name, email, phone;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_data);

        helper = new DatabaseHelper(this);

        update = (Button) findViewById(R.id.button4);

        id = (EditText) findViewById(R.id.editText5);
        name = (EditText) findViewById(R.id.editText6);
        email = (EditText) findViewById(R.id.editText7);
        phone = (EditText) findViewById(R.id.editText8);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdate = helper.updateData(id.getText().toString(),name.getText().toString(), email.getText().toString(), phone.getText().toString());

                if (isUpdate == true) {
                    Toast.makeText(getBaseContext(), "Data Updated Successfully ", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getBaseContext(), "Data not Updated ", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
