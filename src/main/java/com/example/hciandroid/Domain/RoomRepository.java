package com.example.hciandroid.Domain;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.volley.Response;
import java.util.ArrayList;
import com.example.hciandroid.Model.Result;
import com.example.hciandroid.Model.Room.Room;
import com.example.hciandroid.Remote.Api;

public class RoomRepository {
    private static RoomRepository instance;
    private final Api api;

    private RoomRepository(Application application) {
        this.api = Api.getInstance(application);
    }

    public static synchronized RoomRepository get(Application application) {
        if (instance == null) {
            instance = new RoomRepository(application);
        }
        return instance;
    }

    private static <T> Response.Listener<T> getListener(final MutableLiveData<Result<T>> result) {
        return (response) -> result.setValue(new Result<>(response));
    }

    private static <T> Response.ErrorListener getErrorListener(final Api api, final MutableLiveData<Result<T>> result) {
        return (error) -> result.setValue(new Result<>(null, api.handleError(error)));
    }

    public LiveData<Result<Room>> addRoom(Room room) {
        final MutableLiveData<Result<Room>> result = new MutableLiveData<>();
        this.api.addRoom(room, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<Boolean>> modifyRoom(Room room) {
        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.modifyRoom(room, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<Boolean>> deleteRoom(String id) {
        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
        this.api.deleteRoom(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<Room>> getRoom(String id) {
        final MutableLiveData<Result<Room>> result = new MutableLiveData<>();
        this.api.getRoom(id, getListener(result), getErrorListener(api, result));
        return result;
    }

    public LiveData<Result<ArrayList<Room>>> getRooms() {
        final MutableLiveData<Result<ArrayList<Room>>> result = new MutableLiveData<>();
        this.api.getRooms(getListener(result), getErrorListener(api, result));
        return result;
    }
}
