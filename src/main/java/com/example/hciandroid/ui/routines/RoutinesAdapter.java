package com.example.hciandroid.ui.routines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hciandroid.Model.Routine.Routine;
import com.example.hciandroid.R;

import java.util.ArrayList;
import java.util.List;

public class RoutinesAdapter extends RecyclerView.Adapter<RoutinesAdapter.RoutinesViewHolder>{ // implements View.OnClickListener {

    /// Inner Class
    public class RoutinesViewHolder extends RecyclerView.ViewHolder {
        TextView routineName;
        TextView routineInfo;

        public RoutinesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.routineName = itemView.findViewById(R.id.routineNombre);
            this.routineInfo = itemView.findViewById(R.id.routineInfo);
        }
    }
    ////////////////

    // Propiedades
    ArrayList<Routine> routines;
    private final LayoutInflater inflater;
    private View.OnClickListener listener;
    //////////////

    // Constructor
    public RoutinesAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }
    //////////////

    // OnCreate
    @NonNull
    @Override
    public RoutinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.routines_item, parent, false);
       // view.setOnClickListener(this);
        return new RoutinesViewHolder(view);
    }
    ///////////

    // OnBind
    @Override
    public void onBindViewHolder(@NonNull RoutinesViewHolder holder, int position) {
        if (routines != null) {
            Routine current_routine = routines.get(position);
            holder.routineName.setText(current_routine.getName());
            holder.routineInfo.setText(current_routine.getStateToString(current_routine.getState())); /// VER
        }else {
            holder.routineName.setText(R.string.no_routines);
        }
    }
    ///////

    // Set Routines
    void setRoutines(ArrayList<Routine> r){
        this.routines = r;
        notifyDataSetChanged();
    }
    ////////////

    // GetItem
    @Override
    public int getItemCount() {
        if (this.routines != null)
            return this.routines.size();
        else return 0;
    }
    //////////



//////////////////////////// COSAS NUSTRAS QUE NO TIENE EL PELADO ///////////////////////////
//
//    public void setOnClickListener(View.OnClickListener listener){
//        this.listener = listener;
//    }
//
//    @Override
//    public void onClick(View v) {
//        if(listener!=null){
//            listener.onClick(v);
//        }
//    }
//
///////////////////////////////////////////////////////////////////////////////////////////
}
