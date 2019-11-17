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


public class ChangeCodeDialog extends DialogFragment {

    private EditText oldPassword;
    private EditText newPassword;
    private TextView actionOk;
    private TextView actionCancel;

    public ChangeCodeDialogListener listener ;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.change_code_dialog, container, false);

        actionCancel = view.findViewById(R.id.cancel_text_view);
        actionOk = view.findViewById(R.id.ok_text_view);
        oldPassword = view.findViewById(R.id.old_password);
        newPassword = view.findViewById(R.id.new_password);


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

                    String oldPsw = oldPassword.getText().toString();
                    String newPsw = newPassword.getText().toString();

                    if(!oldPsw.equals("") && !newPsw.equals("")){
                        listener.applyTexts(oldPsw, newPsw);
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
            //IMPORTANTISIMO ESTO
            listener = (ChangeCodeDialogListener) getTargetFragment();
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }




    public interface ChangeCodeDialogListener{
        void applyTexts(String oldPsw, String newPsw);

    }


}
