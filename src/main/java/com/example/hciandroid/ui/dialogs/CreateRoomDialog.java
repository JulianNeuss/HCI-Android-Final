package com.example.hciandroid.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.example.hciandroid.R;



public class CreateRoomDialog extends DialogFragment {

    private EditText editTextRoomName;
    private TextView mActionOK;
    private TextView mActionCANCEL;

    public CreateRoomDialogListener listener ;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.create_room_dialog, container, false);

        mActionCANCEL = view.findViewById(R.id.cancel_text_view);
        mActionOK = view.findViewById(R.id.ok_text_view);
        editTextRoomName = view.findViewById(R.id.roomName);


        // BOTON DE CANCEL
        if(mActionCANCEL != null) {

            mActionCANCEL.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                }
            });

        }



        // BOTON DE OK
        if(mActionOK != null) {

            mActionOK.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    //que queremos que haga al darle OK


                    String theRoomName = editTextRoomName.getText().toString();

                    if(! theRoomName.equals("")){
                        listener.applyTexts(theRoomName);
                        getDialog().dismiss();
                    }
                    else
                        Toast.makeText(getContext(), "Invalid Room Name", Toast.LENGTH_SHORT).show();





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
            listener = (CreateRoomDialogListener) getTargetFragment() ;
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }




    //EN EL MAIN ACTIVITY NO NOS PODEMOS OLVIDAR DE IMPLEMENTAR EL CreateRoomDialogListener. SI NOS OLVIDAMOS, VA A SALTAR LA EXCEPCION DE ARRIBA.
    public interface CreateRoomDialogListener{

        void applyTexts(String theRoomName);

    }





}
