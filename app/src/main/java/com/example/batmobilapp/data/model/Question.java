package com.example.batmobilapp.data.model;

import android.graphics.drawable.Drawable;

//Genel kullandıklarımızı tanımlama yeri


public class Question {
    private int id;
    private String title;
    private String description;



    public Question(int id, String title, Drawable icon, String description) {
        this.id = id;
        this.title = title;

        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
