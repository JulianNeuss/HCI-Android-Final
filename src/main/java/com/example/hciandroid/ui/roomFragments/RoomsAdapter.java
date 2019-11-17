package com.example.hciandroid.ui.roomFragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hciandroid.Model.Device.Device;
import com.example.hciandroid.R;

import java.util.ArrayList;
import java.util.List;


public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder> implements View.OnClickListener {


    ArrayList<Device> devices;
    private View.OnClickListener listener;

    public RoomsAdapter(ArrayList<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsAdapter.RoomsViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @NonNull
    @Override
    public RoomsAdapter.RoomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_list,null,false);
        view.setOnClickListener(this);
        return new RoomsAdapter.RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsAdapter.RoomsViewHolder holder, int position) {
        holder.roomName.setText(devices.get(position).toString());
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }


    public class RoomsViewHolder extends RecyclerView.ViewHolder {

        TextView roomName;

        public RoomsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.roomName = itemView.findViewById(R.id.roomName);
        }
    }
}
