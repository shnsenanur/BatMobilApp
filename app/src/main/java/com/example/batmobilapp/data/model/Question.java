package com.example.batmobilapp.data.model;


public class Question {
    int id;
    String title;
    String descreption;
    int catId;

    public Question() {
    }

    public Question(int id, String title, String descreption, int catId) {
        this.id = id;
        this.title = title;
        this.descreption = descreption;
        this.catId = catId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
