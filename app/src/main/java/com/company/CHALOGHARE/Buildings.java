package com.company.CHALOGHARE;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class Buildings {

    private String Name, Description;
    private ArrayList<String> Range;



  private GeoPoint Location;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public ArrayList<String> getRange() {
        return Range;
    }

    public void setRange(ArrayList<String> range) {
        Range = range;
    }

    public GeoPoint getLocation() {
        return Location;
    }

    public void setLocation(GeoPoint location) {
        this.Location = location;
    }
}
