package com.mystudy.linear.GridView;

public class App {
    private String name;
    private int image;

    public App() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public App(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
