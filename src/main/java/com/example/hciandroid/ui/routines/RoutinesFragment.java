package com.example.hciandroid.ui.routines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hciandroid.Model.Routine.Routine;
import com.example.hciandroid.MyApplication;
import com.example.hciandroid.R;

import java.util.ArrayList;

public class RoutinesFragment extends Fragment {

    // constructor sin nada
    public RoutinesFragment() {
    }
    ///////


    private RecyclerView recyclerRoutines;
    private RoutinesViewModel routinesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // CREA LA VIEW
        View root = inflater.inflate(R.layout.fragment_routines, container, false);

        // CATCHEA EL RECYCLEVIEW DEL XML
        recyclerRoutines = root.findViewById(R.id.routines_recycler_view_id);

        // SETEa EL ADAPTER EN el RECYCLE
        recyclerRoutines.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // CREA EL ADAPTER
        final RoutinesAdapter routinesAdapter = new RoutinesAdapter(this.getContext());

        recyclerRoutines.setAdapter(routinesAdapter);

        // CREA VIEW MODEL
        routinesViewModel = ViewModelProviders.of(this).get(RoutinesViewModel.class);

        final Observer<ArrayList<Routine>> nameObserver = new Observer<ArrayList<Routine>> () {
            @Override
            public void onChanged(@Nullable final ArrayList<Routine>  newName) {
                routinesAdapter.setRoutines(newName);
                //routinesAdapter.notifyDataSetChanged();
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        routinesViewModel.getRoutines().observe(this, nameObserver);


        return root;
    }
}

//        Button refreshRoutinesButton = root.findViewById(R.id.refresh_routines_livedata);
//
//
//        if (refreshRoutinesButton != null) {
//            refreshRoutinesButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                    routinesViewModel.updateRoutines();
//
//                }
//            });
//
//
//        }
// routinesViewModel.getRoutines().observe(this,
//          (X) -> routinesAdapter.setRoutines(X)  );

///////////////////////////////////////
//        routinesAdapter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "CLICKEADO", Toast.LENGTH_SHORT).show();
//            }
//        });
