package com.mobileapp.model;

public enum Memory {
    MEMORY4("4GB"),
    MEMORY6("6GB"),
    MEMORY8("8GB");
    public  String totalRam;

    Memory(String totalRam) {
        this.totalRam = totalRam;
    }
}
