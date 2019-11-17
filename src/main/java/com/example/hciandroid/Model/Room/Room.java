package com.example.hciandroid.Model.Room;

public class Room {
    private String id;
    private String name;
    private RoomMeta meta;



    ///gero agrego estas propiedades
    private String info;
    private int imageId;



    //ESTE ES UN NUEVO CONSTRUCTOR QUE AGREGO GERO////////////////////

    public Room(String nombre, String info, int imagenId) {
        this.name = nombre;
        this.info = info;
        this.imageId = imagenId;
    }






    public Room(String name, RoomMeta meta) {
        this.name = name;
        this.meta = meta;
    }

    public Room(String id, String name, RoomMeta meta) {
        this.id = id;
        this.name = name;
        this.meta = meta;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMeta(RoomMeta meta) {
        this.meta = meta;
    }

    public RoomMeta getMeta() {
        return this.meta;
    }





    //////estos nuevos metodos los agrego GERO //////
    public String getInfo(){
        return info;
    }
    public void setInfo(String info){

        this.info = info;
    }



    public int getImageId(){

        return imageId;
    }
    public void setImageId(int imagenId){
        this.imageId=imagenId;
    }

    ////////////////////////////////////////////////








    @Override
    public String toString() {
        if (this.getId() != null)
        {
            if (this.getMeta() != null)
                return String.format("%s - %s - %s", this.getId(), this.getName(), this.getMeta());
            else
                return String.format("%s - %s", this.getId(), this.getName());
        }
        else
        {
            if (this.getMeta() != null)
                return String.format("%s - %s", this.getName(), this.getMeta());
            else
                return this.getName();
        }
    }
}