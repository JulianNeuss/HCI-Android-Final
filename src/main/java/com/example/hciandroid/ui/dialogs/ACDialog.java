package com.example.hciandroid.ui.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.hciandroid.R;


public class ACDialog extends DialogFragment {

    private Button onButton;
    private Button offButton;

    private TextView actionOk;
    private TextView actionCancel;

    private SeekBar temperatureBar;

    private Button hotModeButton;
    private Button coldModeButton;

    public ACDialogListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ac_dialog, container, false);


        onButton = view.findViewById(R.id.on_button);
        offButton = view.findViewById(R.id.off_button);

        hotModeButton = view.findViewById(R.id.hot_button);
        coldModeButton = view.findViewById(R.id.cold_button);

        temperatureBar = view.findViewById(R.id.temperature_bar);

        actionCancel = view.findViewById(R.id.cancel_text_view);
        actionOk = view.findViewById(R.id.ok_text_view);

        // BOTON DE CANCEL
        if (actionCancel != null) {

            actionCancel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                }
            });

        }


        // BOTON DE OK
        if (actionOk != null) {

            actionOk.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    //que queremos que haga al darle OK
                    listener.applyACChanges();
                    getDialog().dismiss();

                }
            });

        }

        if (onButton != null) {
            onButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleButtons(false);
                }
            });
        }

        if (offButton != null) {
            offButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleButtons(true);
                }
            });
        }


        return view;

    }


    private void toggleButtons(boolean enabled) {
        onButton.setEnabled(enabled);
        offButton.setEnabled(!enabled);
        hotModeButton.setEnabled(!enabled);
        coldModeButton.setEnabled(!enabled);
        temperatureBar.setEnabled(!enabled);
    }



    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        try {
            //IMPORTANTISIMO ESTO
            listener = (ACDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }


    public interface ACDialogListener {

        void applyACChanges();

    }

}