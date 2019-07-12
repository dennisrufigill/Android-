package com.example.recyclerviewwithstaggeredviewlm;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Information> getData(){

    ArrayList<Information> data = new ArrayList<>();

    int images[] =
            {
                  R.drawable.a_1,
                    R.drawable.a_2,
                    R.drawable.a_3,

                    R.drawable.london1,
                    R.drawable.ggg,
                    R.drawable.images,
                    R.drawable.cricket_2,
                    R.drawable.a_1,
                    R.drawable.a_2,
                    R.drawable.a_3,

                    R.drawable.london1,
                    R.drawable.ggg,
                    R.drawable.images,
                    R.drawable.cricket_2
            };

        String[] Categories = {"Cat 1", "Cat 2", "Cat 3", "Cat 4" ,
                "Fish 1","Fish 2","Fish 3","Fish 4",
                " Horse 1"," Horse "," Horse 3"," Horse 4",
                " Parrot 1"," Parrot 2"," Parrot 3"," Parrot 4",};

        for (int i = 0; i < images.length; i++) {

            Information current = new Information();
            current.title = Categories[i];
            current.imageId = images[i];

            data.add(current);
        }

        return data;



    }


}
