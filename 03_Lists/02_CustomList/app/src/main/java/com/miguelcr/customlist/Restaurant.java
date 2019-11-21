package com.miguelcr.customlist;

public class Restaurant {
    private String name;
    private String address;
    private String photoUrl;
    private int rate;

    public Restaurant(String name, String address, String photoUrl, int rate) {
        this.name = name;
        this.address = address;
        this.photoUrl = photoUrl;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
