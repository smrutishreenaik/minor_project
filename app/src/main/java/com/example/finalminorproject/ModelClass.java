package com.example.finalminorproject;

public class ModelClass {

    private String imageview1;
    private String title;
    private String vurl;

    ModelClass(String imageview1,String title,String vurl){
        this.imageview1=imageview1;
        this.title=title;
        this.vurl=vurl;
    }

    public String getImageview1() {
        return imageview1;
    }

    public String getTitle() {
        return title;
    }

    public String getVurl(){ return vurl;}

}
