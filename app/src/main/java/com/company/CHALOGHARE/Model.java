package com.company.CHALOGHARE;

import android.widget.Button;

public class Model {
    private int image;
    private String title;
    private Button mapbtn;

    public Model(int image, String title, String desc,Button mapbtn) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.mapbtn=mapbtn;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    public Button getButton(){
        return mapbtn;
    }
    public void setButton(Button mapbtn){
        this.mapbtn=mapbtn;
    }
}