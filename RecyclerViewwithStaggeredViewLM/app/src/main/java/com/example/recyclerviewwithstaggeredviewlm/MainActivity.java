package com.example.recyclerviewwithstaggeredviewlm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    MyCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String myString = "ghgjhg";

        Toast.makeText(getApplicationContext(),""+myString.charAt(1),Toast.LENGTH_SHORT).show();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyCustomAdapter(this, Data.getData());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
