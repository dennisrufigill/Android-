package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReadData extends AppCompatActivity {

    Button btn_search;
    //EditText search;
    TextView text;
    private DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        helper = new DatabaseHelper(this);

        btn_search = (Button) findViewById(R.id.button2);
        text = (TextView) findViewById(R.id.textView5);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = helper.getData();

                StringBuffer buffer = new StringBuffer();

                if(cursor.getCount()>0){
                    while (cursor.moveToNext()) {
                        buffer.append("Id:  " + cursor.getString(0) + "\n");
                        buffer.append("Name: " + cursor.getString(1) + "\n");
                        buffer.append("Email: " + cursor.getString(2) + "\n");
                        buffer.append("Phone: "  + cursor.getString(3)+ "\n\n");
                    }
                    text.setText(buffer.toString());
                    btn_search.setClickable(false);
                    Toast.makeText(getBaseContext(), "Data retreived Successfully ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Data is not retrieved  ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
