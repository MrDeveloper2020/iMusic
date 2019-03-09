package com.example.reza.imusic;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.reza.imusic.adapter.LibraryAdapter;
import com.example.reza.imusic.model.LibraryModel;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    private List<LibraryModel> libraryModel = new ArrayList<>();
    private RecyclerView recyclerView;
    private LibraryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_library);
        adapter = new LibraryAdapter(libraryModel,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);


        setData();


    }

    private void setData() {
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
        libraryModel.add(new LibraryModel(1,"","Mazyar Fallahi - Doroghe","22"));
    }
}
