package com.example.retrofitpostabhiandroid;

import android.widget.RelativeLayout;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Retrofit retrofit = null;

    public static ApiInterface getClient(){


        // we can change our base url here.

        if(retrofit == null){

            retrofit =  new Retrofit.Builder()
                    .baseUrl("https://mobileappdatabase.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

//Creating Object of our Interface

        ApiInterface api = retrofit.create(ApiInterface.class);

        return api;  //return the Api Interface


    }



}
