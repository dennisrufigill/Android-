package com.example.dennis.dennisapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Dennis on 9/22/2016.
 */
public class MenuActivity extends AppCompatActivity {


    GridView gv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        gv = (GridView) findViewById(R.id.gv);
        Integer[]images={R.drawable.busone,R.drawable.busone,R.drawable.busone,R.drawable.busone,R.drawable.busone,R.drawable.busone};
        final ArrayList<String> titles=new ArrayList<String>();
        titles.add("Add Driver");
        titles.add("Driver");
        titles.add("Add Bus");
        titles.add("Bus");
        titles.add("Add Route");
        titles.add("Route");

GridAdapter ad = new GridAdapter(MenuActivity.this,titles,images);
        gv.setAdapter(ad);

      gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              String str = titles.get(position);

              if(str == "Add Driver")
              {
                  Intent i = new Intent(getBaseContext(),AddDriver.class);
                  startActivity(i);
              }

              else if(str =="Add Bus")
              {
                  Intent j = new Intent(getBaseContext(),AddBus.class);
                  startActivity(j);
              }


              else if(str =="Add Route")
              {
                  Intent k = new Intent(getBaseContext(),AddRoute.class);
                  startActivity(k);
              }


          }
      });


    }
}
