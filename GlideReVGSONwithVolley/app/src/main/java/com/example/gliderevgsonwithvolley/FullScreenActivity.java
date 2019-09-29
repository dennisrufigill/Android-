package com.example.gliderevgsonwithvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        ImageView imageView = findViewById(R.id.imageViewFullScreen);

        Intent callActivityIntent = getIntent();

        if(callActivityIntent !=null){

            Uri imageUri = callActivityIntent.getData();

            if(imageUri !=null && imageView !=null){

                Glide.with(this).load(imageUri).into(imageView);
            }
        }


    }
}
