package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListData[] myListData = new MyListData[]{

                new MyListData("Cat 1", R.drawable.loading),
                new MyListData("Cat 2", R.drawable.download1),
                new MyListData("Cat 3", R.drawable.loading),
                new MyListData("Cat 4", R.drawable.download1),
                new MyListData("Fish 1", R.drawable.error),
                new MyListData("Fish 2", R.drawable.error),
                new MyListData("Fish 3", R.drawable.error),
                new MyListData("Fish 4", R.drawable.loading),
                new MyListData("Horse 1", R.drawable.error),
                new MyListData("Horse 2", R.drawable.error),
                new MyListData("Horse 3", R.drawable.download1),
                new MyListData("Horse 4", R.drawable.loading),
                new MyListData("Parrot 1", R.drawable.error),
                new MyListData("Parrot 2", R.drawable.download1),
                new MyListData("Parrot 3", R.drawable.error),
                new MyListData("Parrot 4", R.drawable.loading),


        };


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
