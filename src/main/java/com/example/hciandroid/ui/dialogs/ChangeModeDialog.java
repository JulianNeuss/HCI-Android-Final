package com.example.hciandroid.ui.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.hciandroid.R;


public class ChangeModeDialog extends DialogFragment {

    private String mode;

    private EditText password;
    private TextView actionOk;
    private TextView actionCancel;

    public ChangeModeDialogListener listener ;

    public ChangeModeDialog(String mode) {
        this.mode = mode;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.change_alarm_mode_dialog, container, false);

        actionCancel = view.findViewById(R.id.cancel_text_view);
        actionOk = view.findViewById(R.id.ok_text_view);
        password = view.findViewById(R.id.psw);


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

                    String pass = password.getText().toString();

                    if(!pass.equals("")){
                        listener.applyModeChanges(mode,pass);
                        getDialog().dismiss();
                    }
                    else
                        Toast.makeText(getContext(), "wrong password", Toast.LENGTH_SHORT).show();
                }
            });

        }


        return view;
    }






    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        try {
            listener = (ChangeModeDialogListener) getTargetFragment();
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }




    public interface ChangeModeDialogListener{
        void applyModeChanges(String mode, String psw);
    }


}
