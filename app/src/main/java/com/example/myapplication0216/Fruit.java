package com.example.myapplication0216;

public class Fruit {
    private String name; // 名称
    private int imgId; // 对应图片的资源id

    public Fruit(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
