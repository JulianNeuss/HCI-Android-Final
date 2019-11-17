package com.example.hciandroid;

import android.app.Application;

import com.example.hciandroid.Domain.DeviceRepository;
import com.example.hciandroid.Domain.RoomRepository;
import com.example.hciandroid.Domain.RoutinesRepository;

public class MyApplication extends Application {
    private static MyApplication instance;
    private RoomRepository roomRepository;
    private RoutinesRepository routinesRepository;
    private DeviceRepository deviceRepository;

    public static MyApplication getInstance() {
        return instance;
    }

    public static void setInstance(MyApplication instance) {
        MyApplication.instance = instance;
    }

    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoutinesRepository getRoutinesRepository() {
        return routinesRepository;
    }

    public void setRoutinesRepository(RoutinesRepository routinesRepository) {
        this.routinesRepository = routinesRepository;
    }

    public DeviceRepository getDeviceRepository() {
        return deviceRepository;
    }

    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        routinesRepository = RoutinesRepository.get(this);
        roomRepository = RoomRepository.get(this);
        deviceRepository = DeviceRepository.get(this);
        instance = this;
    }

    public synchronized static MyApplication getInstace() {
        return instance;
    }

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }
}
