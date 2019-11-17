package com.example.hciandroid.ui.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.hciandroid.R;

public class DoorDialog extends DialogFragment {

    private Button openButton;
    private Button closeButton;

    private Switch lockUnlockSwitch;
    private TextView actionOk;
    private TextView actionCancel;

    public DoorDialogListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.door_dialog,container,false);


        openButton = view.findViewById(R.id.open_button);
        closeButton = view.findViewById(R.id.close_button);

        lockUnlockSwitch = view.findViewById(R.id.lock_unlock_switch);

        actionCancel = view.findViewById(R.id.cancel_text_view);
        actionOk = view.findViewById(R.id.ok_text_view);

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
                        listener.applyDoorChanges();
                        getDialog().dismiss();

                }
            });

        }

        if(openButton != null) {
            openButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleButtons(false);
                }
            });
        }

        if(closeButton != null){
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleButtons(true);
                }
            });
        }


        return view;

    }


    private void toggleButtons(boolean enabled){
        openButton.setEnabled(enabled);
        closeButton.setEnabled(!enabled);
        lockUnlockSwitch.setEnabled(!enabled);
    }


    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        try {
            //IMPORTANTISIMO ESTO
            listener = (DoorDialogListener) getTargetFragment();
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }


    public interface DoorDialogListener{

        void applyDoorChanges();

    }
}
