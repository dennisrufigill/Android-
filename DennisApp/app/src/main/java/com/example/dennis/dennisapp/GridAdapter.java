package com.example.dennis.dennisapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> titles;
    LayoutInflater inflater;
    Integer[] images;


    public GridAdapter (Context context, ArrayList<String> titles,Integer[]images){

        this.context= context;
        this.titles=titles;
        this.images=images;
        inflater=LayoutInflater.from(context);
    }






    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null)
        {

            view=inflater.inflate(R.layout.gridlayout,viewGroup,false);
            TextView tvTitle= (TextView) view.findViewById(R.id.textView);
            ImageView ivLogo=(ImageView) view.findViewById(R.id.imageView);
            tvTitle.setText(titles.get(position));
            ivLogo.setBackgroundResource(images[position]);

        }
        return view;
    }
}
