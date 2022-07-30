package com.example.a542j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Story> items;

    public Adapter(Context context, ArrayList<Story> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stories, parent, false);
        return new StoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Story story = items.get(position);

        if (holder instanceof StoryHolder){
           ImageView i_image =  ((StoryHolder) holder).i_image;
           ShapeableImageView profile = ((StoryHolder) holder).profile;
           ShapeableImageView counter =((StoryHolder) holder).counter;
           TextView i_text = ((StoryHolder)holder).i_text;

           i_image.setImageResource(story.i_image);
           profile.setImageResource(story.profile);
           counter.setImageResource(story.counter);
           i_text.setText(story.i_text);

           if (position == 0){
               counter.setVisibility(View.GONE);
           }else {
               counter.setVisibility(View.VISIBLE);
           }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class StoryHolder extends RecyclerView.ViewHolder{

        ShapeableImageView  profile, counter;
        ImageView i_image;
        TextView i_text;
        public StoryHolder(@NonNull View itemView) {
            super(itemView);

            i_image = itemView.findViewById(R.id.i_image);
            profile = itemView.findViewById(R.id.i_profile);
            counter = itemView.findViewById(R.id.counter);
            i_text = itemView.findViewById(R.id.i_text);
        }
    }
}
