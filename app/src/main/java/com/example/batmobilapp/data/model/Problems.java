package com.example.batmobilapp.data.model;

import android.graphics.Bitmap;

public class Problems {
    private int CatID;
    private String CatName;
    private Bitmap CatIcon;
    private int SayAbout;

    public Problems() {
    }

    public Problems(int catID, String catName, Bitmap catIcon) {
        CatID = catID;
        CatName = catName;
        CatIcon = catIcon;
    }

    public Problems(int catID, String catName, Bitmap catIcon, int sayAbout) {
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

    public Bitmap getCatIcon() {
        return CatIcon;
    }

    public void setCatIcon(Bitmap catIcon) {
        CatIcon = catIcon;
    }

    public int getSayAbout() {
        return SayAbout;
    }

    public void setSayAbout(int sayAbout) {
        SayAbout = sayAbout;
    }
}
