package com.example.batmobilapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User  {
   private String id;
   private String username;
   private int age;
   private String email;
   private int userRating;
   private String image;

    public User(String id, String username, int age, String email, int userRating, String image) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
        this.userRating = userRating;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}
