package com.example.batmobilapp.data.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Problems {
    private int CatID;
    private String CatName;
    private Drawable CatIcon;
    private String SayAbout;

    public Problems() {
    }

    public Problems(int catID, String catName, Drawable catIcon) {
        CatID = catID;
        CatName = catName;
        CatIcon = catIcon;
    }

    public Problems(int catID, String catName, Drawable catIcon, String sayAbout) {
        CatID = catID;
        CatName = catName;
        CatIcon = catIcon;
        SayAbout = sayAbout;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int catID) {
        CatID = catID;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }

    public Drawable getCatIcon() {
        return CatIcon;
    }

    public void setCatIcon(Drawable catIcon) {
        CatIcon = catIcon;
    }

    public String getSayAbout() {
        return SayAbout;
    }

    public void setSayAbout(String sayAbout) {
        SayAbout = sayAbout;
    }
}
