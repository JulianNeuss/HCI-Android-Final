package com.example.hciandroid.ui.dialogs;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.hciandroid.R;



public class OvenDialog extends DialogFragment {


    private Button onButton;
    private Button offButton;

    private SeekBar seekBar;

    private Button hotModeUpButton;
    private Button hotModeFullButton;
    private Button hotModeDownButton;
    private Button grillModeOffButton;
    private Button grillModeEcoButton;
    private Button grillModeFullButton;

    private Button convectionModeOffButton;
    private Button convectionModeEcoButton;
    private Button convectionModeFullButton;

    private TextView actionOK;
    private TextView actionCancel;

    //private OvenDialogListener listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.oven_dialog, container, false);

        onButton = view.findViewById(R.id.on_oven_button);
        offButton = view.findViewById(R.id.off_oven_button);

        seekBar = view.findViewById(R.id.temperature_bar);

        hotModeUpButton = view.findViewById(R.id.hot_up);
        hotModeFullButton = view.findViewById(R.id.hot_full);
        hotModeDownButton =view.findViewById(R.id.hot_down);

        grillModeOffButton = view.findViewById(R.id.grill_off);
        grillModeEcoButton = view.findViewById(R.id.grill_eco);
        grillModeFullButton =view.findViewById(R.id.grill_full);

        convectionModeEcoButton = view.findViewById(R.id.convection_eco);
        convectionModeOffButton = view.findViewById(R.id.convection_off);
        convectionModeFullButton =view.findViewById(R.id.convection_full);


        actionCancel = view.findViewById(R.id.cancel_text_view);
        actionOK = view.findViewById(R.id.ok_text_view);


        // BOTON DE CANCEL
        if(actionCancel != null) {
            actionCancel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                }
            });

        }


        // BOTON DE OK
        if(actionOK != null) {
            actionOK.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    Toast.makeText(getContext(), "Hasta aca llegamos bien", Toast.LENGTH_SHORT).show();

                }
            });

        }


        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);



    }

    //EN EL MAIN ACTIVITY NO NOS PODEMOS OLVIDAR DE IMPLEMENTAR EL CreateRoomDialogListener. SI NOS OLVIDAMOS, VA A SALTAR LA EXCEPCION DE ARRIBA.
    public interface OvenDialogListener{

        void applyChanges(String theRoomName);

    }





}
