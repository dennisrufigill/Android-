package com.example.recyclerviewwithretrofitget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

   Context ctx;
   List<Hero> heroList;

    public HeroesAdapter(Context ctx, List<Hero> heroList) {
        this.ctx = ctx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       // LayoutInflater inflater;
        View view = LayoutInflater.from(ctx).inflate(R.layout.recyclerview_layout, parent, false);

        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {

        final Hero hero = heroList.get(position);

        Glide.with(ctx).load(hero.getImageurl()).into(holder.imageView);

        holder.textView.setText(hero.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), ""+hero.getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
       return heroList.size();

      //  return null!=heroList?heroList.size():0;
    }

    public class HeroViewHolder  extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);

        }
    }
}
