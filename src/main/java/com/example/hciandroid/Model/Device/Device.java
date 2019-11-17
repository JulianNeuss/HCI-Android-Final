package com.example.hciandroid.Model.Device;

public class Device {
    private String id;
    private DeviceType type;
    private String name;
    private DeviceMeta meta;

    public Device(DeviceType type, String name, DeviceMeta meta) {
        this.type = type;
        this.name = name;
        this.meta = meta;
    }

    public Device(DeviceType type, String id, String name, DeviceMeta meta) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.meta = meta;
    }

    public String getType() {
        return type.toString();
    }

    public void setType(DeviceType type) {
        this.type = type;
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

    public void setMeta(DeviceMeta meta) {
        this.meta = meta;
    }

    public DeviceMeta getMeta() {
        return this.meta;
    }

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
