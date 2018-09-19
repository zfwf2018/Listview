package com.example.zf.listviewtest;

/**
 * Created by zf on 2018/1/8.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;

    }
    public int getImageId(){
        return imageId;
    }
}
