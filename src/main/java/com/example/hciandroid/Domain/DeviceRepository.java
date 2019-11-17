package com.example.hciandroid.Domain;

import android.app.Application;

import com.example.hciandroid.Model.Device.Device;
import com.example.hciandroid.Remote.Api;


public class DeviceRepository {

    private static DeviceRepository instance;
    private final Api api;

    private DeviceRepository(Application application) {
        this.api = Api.getInstance(application);
    }


    public static synchronized DeviceRepository get(Application application) {
        if (instance == null) {
            instance = new DeviceRepository(application);
        }
        return instance;
    }
}
