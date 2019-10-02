package com.example.batmobilapp.data.model;

import android.graphics.drawable.Drawable;

public class Category {
    private int id;
    private String title;
    private Drawable icon;
    private String description;



    public Category(int id, String title, Drawable icon, String description) {
        this.id = id;
        this.title = title;
        this.icon = icon;
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

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
