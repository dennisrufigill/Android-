package com.example.fileuploadpractice;

import
        androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {


    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView =  findViewById(R.id.imageView);

       Intent intent = getIntent();

    String str = intent.getStringExtra("key");

        Log.e("str", str);

        Glide.with(this).load(str).into(imageView);











    //imageView.setImageResource(str);
 //  imageView.setImageURI(str);

 //   imageView.setImageResource(Integer.parseInt("key"));



    }
}
