package com.example.reza.imusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reza.imusic.R;
import com.example.reza.imusic.model.LibraryModel;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    List<LibraryModel> libraries;
    Context context;

    public LibraryAdapter(List<LibraryModel> libraries, Context context) {
        this.libraries = libraries;
        this.context = context;
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_library,parent,false);
        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {

    LibraryModel library = libraries.get(position);

        holder.text_music.setText(library.getTextLibrary());
        holder.tedad_music.setText(library.getTedadLibrary());
    }

    @Override
    public int getItemCount() {
        return libraries.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder{

        public ImageView image_music;
        public TextView text_music;
        public TextView tedad_music;
        public CardView cardView;

        public LibraryViewHolder(View itemView) {
            super(itemView);

            image_music = (ImageView)itemView.findViewById(R.id.image_library);
            text_music = (TextView)itemView.findViewById(R.id.text_library);
            tedad_music = (TextView)itemView.findViewById(R.id.tedad_library);
            cardView = (CardView)itemView.findViewById(R.id.cardview_library);
        }
    }
}
