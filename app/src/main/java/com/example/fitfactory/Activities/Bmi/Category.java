package com.example.fitfactory.Activities.Bmi;

public class Category {

    String title, range;
    int imageRec;

    public Category(String title, String range, int imageRec) {
        this.title = title;
        this.range = range;
        this.imageRec = imageRec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getImageRec() {
        return imageRec;
    }

    public void setImageRec(int imageRec) {
        this.imageRec = imageRec;
    }
}
