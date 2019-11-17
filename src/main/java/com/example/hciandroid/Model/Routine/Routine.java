package com.example.hciandroid.Model.Routine;


public class Routine {

    private String id;
    private String name;
    private boolean state;

    public Routine(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Routine(String id, String name, boolean state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResponse(boolean response) {
        this.state = response;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public String getStateToString(Boolean bu){
        if (bu == true){
            return "Running";
        }
        return "Blocked";
    }

}
