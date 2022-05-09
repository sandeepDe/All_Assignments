package com.mobileapp.model;

public enum Storage {
    STORAGE12("12GB"),
    STORAGE32("32GB"),
    STORAGE64("64GB"),
    STORAGE128("128GB");

    public String capacity;

    Storage(String capacity) {
        this.capacity = capacity;
    }
}
