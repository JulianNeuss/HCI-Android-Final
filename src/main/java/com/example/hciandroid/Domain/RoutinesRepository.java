package com.example.hciandroid.Domain;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.volley.Response;
import com.example.hciandroid.Model.Result;
import com.example.hciandroid.Model.Routine.Routine;
import com.example.hciandroid.Remote.Api;
import java.util.ArrayList;


//////



public class RoutinesRepository {
        private static com.example.hciandroid.Domain.RoutinesRepository instance;
        private final Api api;

    private RoutinesRepository(Application application) {
        this.api = Api.getInstance(application);
    }

    public static synchronized RoutinesRepository get(Application application) {
        if (instance == null) {
            instance = new RoutinesRepository(application);
        }
        return instance;
    }

    private static <T> Response.Listener<T> getListener(final MutableLiveData<Result<T>> result) {
        return (response) -> result.setValue(new Result<>(response));
    }

    private static <T> Response.ErrorListener getErrorListener(final Api api, final MutableLiveData<Result<T>> result) {
        return (error) -> result.setValue(new Result<>(null, api.handleError(error)));
    }




    public MutableLiveData<Result<ArrayList<Routine>>> getRoutines() {
        final MutableLiveData<Result<ArrayList<Routine>>> result = new MutableLiveData<>();
        this.api.getRoutines(getListener(result), getErrorListener(api, result));
        return result;
    }

//    public LiveData<Result<Boolean>> executeRoutine(Routine routine) {
//        final MutableLiveData<Result<Boolean>> result = new MutableLiveData<>();
//        this.api.executeRoutine(routine,getListener(result), getErrorListener(api,result));
//        return result;
//    }


}
