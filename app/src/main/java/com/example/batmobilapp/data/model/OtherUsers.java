package com.example.batmobilapp.data.model;

public class OtherUsers {
    private String id;
    private String username;
    private int age;
    private int rate;
    private String photoUrl;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public OtherUsers(String id, String username, int age, String photoUrl) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.photoUrl = photoUrl;
    }
}
