package com.example.gliderevgsonwithvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private static final String URL = "https://api.github.com/users";
    private static final int COUNT = 50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView userlist = findViewById(R.id.userList);
        userlist.setLayoutManager(new LinearLayoutManager(this));


//      StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
//          @Override
//          public void onResponse(String response) {

//              Log.d("CODE", response);
//              GsonBuilder gsonBuilder = new GsonBuilder();
//              Gson gson = gsonBuilder.create();
//              User [] users = gson.fromJson(response,User[].class);

              ArrayList<User> users = new ArrayList<>();
              for(int i= 1; i<COUNT; i++ ){

                  User u = new User();
u.setAvatarUrl("http://placehold.it/"+i+"x"+i);
u.setLogin("Name "+i);


                  users.add(u);
              }


              userlist.setAdapter(new GithubAdapter(MainActivity.this, users));

//          }
//      }, new Response.ErrorListener() {
//          @Override
//          public void onErrorResponse(VolleyError error) {
//
//              Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//          }
//      });
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);



    }
}
