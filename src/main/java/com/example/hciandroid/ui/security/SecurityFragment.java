package com.example.hciandroid.ui.security;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.hciandroid.Model.Device.Device;
import com.example.hciandroid.Model.Device.DeviceMeta;
import com.example.hciandroid.Model.Device.DeviceType;
import com.example.hciandroid.R;
import com.example.hciandroid.Remote.Api;
import com.example.hciandroid.ui.dialogs.ChangeCodeDialog;
import com.example.hciandroid.ui.dialogs.ChangeModeDialog;

public class SecurityFragment extends Fragment implements ChangeCodeDialog.ChangeCodeDialogListener, ChangeModeDialog.ChangeModeDialogListener {

    private String requestTag;
    private Context context;
    private RelativeLayout alarmLayout;
    private Button changeCode;
    private Button homeMode;
    private Button awayMode;
    private Button disarm;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        context = this.getContext();

        View view = inflater.inflate(R.layout.fragment_safety,container,false);
        alarmLayout = view.findViewById(R.id.alarm_safety_layout);
        alarmLayout.requestLayout();

        /* ************************************
         *               CHANGE CODE
         * ************************************/
        changeCode = view.findViewById(R.id.change_code);
        if (changeCode != null) {
            changeCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openChangeCodeDialog();

                    Toast.makeText(getContext(), "CHANGE CODE DONE",Toast.LENGTH_SHORT).show();
                }
            });
        }

        /* ************************************
         *               HOME MODE
         * ************************************/
        homeMode = view.findViewById(R.id.home_mode);
        if (homeMode != null) {
            homeMode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openChangeModeDialog("armStay");


                    toggleChangeAlarmMode(true);
                    Toast.makeText(getContext(), "HOME MODE ON",Toast.LENGTH_SHORT).show();
                }
            });
        }

        /* ************************************
         *              AWAY MODE
         * ************************************/
        awayMode = view.findViewById(R.id.regular_mode);
        if (awayMode != null) {
            awayMode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /* NUEVO (para dialogo) */
                    openChangeModeDialog("armAway");


                    toggleChangeAlarmMode(false);
                    Toast.makeText(getContext(), "AWAY MODE ON",Toast.LENGTH_SHORT).show();
                }
            });
        }

        /* ************************************
         *               DISARM ALARM
         * ************************************/
        disarm = view.findViewById(R.id.disarm_alarm);
        if (disarm != null) {
            disarm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /* NUEVO (para dialogo) */
                    openChangeModeDialog("disarm");

                    toggleButtons(true);
                    Toast.makeText(getContext(), "DISARM ALARM",Toast.LENGTH_SHORT).show();
                }
            });
        }
        return view;
    }

    private void toggleButtons(boolean enabled){
        homeMode.setEnabled(enabled);
        awayMode.setEnabled(enabled);
        disarm.setEnabled(!enabled);
    }

    private void toggleChangeAlarmMode(boolean enabled){
        homeMode.setEnabled(!enabled);
        awayMode.setEnabled(enabled);
        if(!disarm.isEnabled()){
            disarm.setEnabled(true);
        }
    }

    private void  openChangeCodeDialog(){
        ChangeCodeDialog changeCodeDialog = new ChangeCodeDialog() ;
        changeCodeDialog.setTargetFragment(SecurityFragment.this , 1);
        changeCodeDialog.show( getFragmentManager() , "change code dialog");
    }

    private void openChangeModeDialog(String mode){
        ChangeModeDialog changeModeDialog = new ChangeModeDialog(mode);
        changeModeDialog.setTargetFragment(SecurityFragment.this,1);
        changeModeDialog.show(getFragmentManager(), "change Mode");
    }

    @Override
    public void applyTexts(String oldPsw, String newPsw) {
        Log.e("changes:", "Cambios " + oldPsw + "----" + newPsw);
    }

    @Override
    public void applyModeChanges(String mode, String psw) {
        String []param = new String[1];
        param[0] = psw;
        requestTag = Api.getInstance(context).changeDeviceStatus("af225d348b93a223", mode, param, new Response.Listener<Boolean>() {
            @Override
            public void onResponse(Boolean response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.toString());
            }
        });

        Log.e("changes:", "Cambios " + psw + "----" );
    }
}