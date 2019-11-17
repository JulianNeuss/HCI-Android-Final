package com.example.hciandroid.Model.Device;

public class DeviceMeta {

    private Boolean fav;

    public DeviceMeta(Boolean size) {
        this.fav = size;
    }

    public void setFav(Boolean size) {
        this.fav = size;
    }

    public Boolean getFav() {
        return this.fav;
    }

    @Override
    public String toString(){
        return this.getFav().toString();
    }

}
