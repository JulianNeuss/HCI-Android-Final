package com.example.hciandroid.ui.roomFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hciandroid.Model.Device.Device;
import com.example.hciandroid.Model.Device.DeviceMeta;
import com.example.hciandroid.Model.Device.DeviceType;
import com.example.hciandroid.R;

import java.util.ArrayList;

public class RoomFragment extends Fragment{

    private RecyclerView recyclerDevices;
    private ArrayList<Device> devices;





    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        devices = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_room,container,false);
        recyclerDevices = view.findViewById(R.id.room_recycler_view_id);
        recyclerDevices.setLayoutManager(new LinearLayoutManager(getContext()));
        RoomsAdapter roomsAdapter = new RoomsAdapter(devices);
        recyclerDevices.setAdapter(roomsAdapter);
        roomsAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "CLICKEADO",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    //este tiene que pedirle los datos a la API
    private void fillList(){
        devices.add(new Device(new DeviceType("c89b94e8581855bc"),"Heladera", new DeviceMeta(false)));
        devices.add(new Device(new DeviceType("c89b94e8581855bc"),"Horno", new DeviceMeta(false)));
        devices.add(new Device(new DeviceType("c89b94e8581855bc"),"Parlante",new DeviceMeta(false)));
        devices.add(new Device(new DeviceType("c89b94e8581855bc"),"Parlante2",new DeviceMeta(false)));

    }









}