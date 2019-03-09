package com.example.reza.imusic.model;

import android.widget.ImageView;
import android.widget.TextView;

public class LibraryModel {

    private int id;
    private String imageLibrary;
    private String textLibrary;
    private String tedadLibrary;

    public LibraryModel(int id, String imageLibrary, String textLibrary, String tedadLibrary) {
        this.id = id;
        this.imageLibrary = imageLibrary;
        this.textLibrary = textLibrary;
        this.tedadLibrary = tedadLibrary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLibrary() {
        return imageLibrary;
    }

    public void setImageLibrary(String imageLibrary) {
        this.imageLibrary = imageLibrary;
    }

    public String getTextLibrary() {
        return textLibrary;
    }

    public void setTextLibrary(String textLibrary) {
        this.textLibrary = textLibrary;
    }

    public String getTedadLibrary() {
        return tedadLibrary;
    }

    public void setTedadLibrary(String tedadLibrary) {
        this.tedadLibrary = tedadLibrary;
    }

    @Override
    public String toString() {
        return "LibraryModel{" +
                "id=" + id +
                ", imageLibrary='" + imageLibrary + '\'' +
                ", textLibrary='" + textLibrary + '\'' +
                ", tedadLibrary='" + tedadLibrary + '\'' +
                '}';
    }
}

