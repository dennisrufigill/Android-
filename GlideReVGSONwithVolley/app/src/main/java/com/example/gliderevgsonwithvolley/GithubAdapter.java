package com.example.gliderevgsonwithvolley;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {

    private Context context;
    private User [] data;
    private ArrayList<User> dataList;
    public GithubAdapter(Context context, User[] data) {

        this.context = context;
        this.data = data;
    }

    public GithubAdapter(MainActivity context, ArrayList<User> users) {

        this.context = context;
        this.dataList = users;
    }


    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GithubViewHolder holder, int position) {
        final User user;
        if(data != null)        {
    user = data[position];
}else{
            user = dataList.get(position);
}

        holder.txtUser.setText(user.getLogin());
        Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).placeholder(R.drawable.loading).into(holder.imgUser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Toast.makeText(context, user.getLogin()+ "  was clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent( view.getContext(),FullScreenActivity.class);
                intent.setData(Uri.parse(user.getAvatarUrl()));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if(data!=null)
        return data.length;
        else return dataList.size();
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{

        ImageView imgUser;
        TextView txtUser;

        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.imgUser);
            txtUser = itemView.findViewById(R.id.txtUser);
        }
    }
}
