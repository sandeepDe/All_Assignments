package com.mobileapp.model;

public enum Camera {
    FRONT("front camera")
    , REAR("rear camera") ,
    DUAL("front and rear camera");

    private String cameraType;

    Camera(String type) {
        this.cameraType = type;
    }

    public  String getType(){
        return  this.cameraType;
    }
}
