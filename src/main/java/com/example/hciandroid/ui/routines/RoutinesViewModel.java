package com.example.hciandroid.ui.routines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.hciandroid.Model.Result;
import com.example.hciandroid.Model.Routine.Routine;
import com.example.hciandroid.MyApplication;

import java.util.ArrayList;

public class RoutinesViewModel extends ViewModel {

    private MutableLiveData<Result<ArrayList<Routine>>> routines;



    public RoutinesViewModel() {
        super();
        this.routines = MyApplication.getInstace().getRoutinesRepository().getRoutines();
    }



    public void updateRoutines(){
            if (routines != null )
            routines.setValue(  MyApplication.getInstace().getRoutinesRepository().getRoutines().getValue()  );

    }





    public MutableLiveData<ArrayList<Routine>> getRoutines() {


       return (MutableLiveData<ArrayList<Routine>>) Transformations.map(this.routines, (result) ->  result.getResult()  );



    }

}

