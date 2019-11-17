package com.example.hciandroid.ui.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.hciandroid.R;

public class RefigeratorDialog extends DialogFragment {

    private TextView actionCancel;
    private TextView actionOk;

    private Button normalButton;
    private Button partyButton;
    private Button holidayButton;

    public RefrigeratorDialogListener listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.refrigerator_dialog, container, false);

        actionCancel = view.findViewById(R.id.cancel_text_view);
        actionOk = view.findViewById(R.id.ok_text_view);

        normalButton = view.findViewById(R.id.normal_mode);
        partyButton = view.findViewById(R.id.party_mode);
        holidayButton = view.findViewById(R.id.holiday_mode);



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
        if(actionOk != null) {

            actionOk.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                        //que queremos que haga al darle OK
                        listener.applyRefriChanges();
                        getDialog().dismiss();

                }
            });

        }

        if(normalButton != null){
            normalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleNormalButton(false);
                }
            });
        }

        if(partyButton!= null){
            partyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    togglePartyButton(false);
                }
            });
        }

        if(holidayButton!= null){
            holidayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleHolidayButton(false);
                }
            });
        }


        return view;
    }


    private void toggleNormalButton(boolean enabled){
        normalButton.setEnabled(enabled);
        partyButton.setEnabled(!enabled);
        holidayButton.setEnabled(!enabled);
    }

    private void togglePartyButton(boolean enabled){
        partyButton.setEnabled(enabled);
        normalButton.setEnabled(!enabled);
        holidayButton.setEnabled(!enabled);
    }

    private void toggleHolidayButton(boolean enabled){
        holidayButton.setEnabled(enabled);
        normalButton.setEnabled(!enabled);
        partyButton.setEnabled(!enabled);
    }



    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);


        try {
            //IMPORTANTISIMO ESTO
            listener = (RefrigeratorDialogListener) getTargetFragment();
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }




    public interface RefrigeratorDialogListener{
        void applyRefriChanges();
    }



}
