package com.example.batmobilapp.data.model;

public class Data {
    String cat;
    String number;
    int id;


    public Data() {
    }

    public Data(String cat, String number, int id) {
        this.cat = cat;
        this.number = number;
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
