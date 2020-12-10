package com.nayyab.tech.waziristantourismadmin;

public class ModelClass {

    String Name, Summary, ImageNo1;

    public ModelClass() {
    }

    public ModelClass(String name, String summary, String imageNo1) {
        Name = name;
        Summary = summary;
        ImageNo1 = imageNo1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getImageNo1() {
        return ImageNo1;
    }

    public void setImageNo1(String imageNo1) {
        ImageNo1 = imageNo1;
    }
}
