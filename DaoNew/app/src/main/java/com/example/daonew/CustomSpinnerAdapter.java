package com.example.daonew;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daonew.database.Course;
import com.example.daonew.database.Users;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter {


    LayoutInflater mlayoutInflater;
    Context mcontext;
    List items;
    int mResource;


    public CustomSpinnerAdapter(Context context, int resource, List objects) {
        super(context, resource, 0, objects);

        mcontext = context;
        mlayoutInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;


    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {

        final View view = mlayoutInflater.inflate(mResource, parent, false);

        TextView nametextview = (TextView) view.findViewById(R.id.textview_custom);


          Course course = (Course) items.get(position);

        //Users users = (Users) items.get(position);

        //    Users users = (Users) items.get(position);

          nametextview.setText(course.getName());
        // nametextview.setText(users.getName());


   //     Users users = (Users) items.get(position);
     //   nametextview.setText(users.getName());


        return view;
    }
}
