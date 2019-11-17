package com.example.hciandroid.Model.Room;


public class RoomMeta {

    private Boolean fav;

    public RoomMeta(Boolean size) {
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
