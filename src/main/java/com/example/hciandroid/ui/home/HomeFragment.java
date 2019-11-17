package com.example.hciandroid.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;





import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;




import com.example.hciandroid.Remote.Api;
import com.example.hciandroid.R;
import com.example.hciandroid.Model.Room.Room;
import com.example.hciandroid.ui.dialogs.CreateRoomDialog;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements CreateRoomDialog.CreateRoomDialogListener {

    public static HomeViewModel homeViewModel;

    //////////// NUEVAS PROPIEDADES ////////////
    final ArrayList<Room> listaRooms = new ArrayList<>();
    RecyclerView recyclerRooms;
    ////////////////////////////////////////////////


    //////ESTAMOS HACIANDO EL BOTON DE CREAR ROOM////////////////////////////
    private Room room;
    private Button createRoomButton;
    private int index = 1;
    private String requestTag;
    private Context context;
    private final String LOG_TAG = "ar.edu.itba.apiexample";
    private TextView resultTextView;




    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);



        //OBTENEMOS EL VIEW DESDE EL DOCUMENTO XML QUE SE NOS CANTA!!! EN ESTE CASO fragment_home
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        ///////////////////NUEVO CODIGO agrego GERO PARA MOSTRAR LA LISTA DE ROOMS//////////////////////////

        //el recycler lo saca del xml "fragment_home"!
        recyclerRooms = root.findViewById(R.id.recyclerId);
        recyclerRooms.setLayoutManager(new LinearLayoutManager(getContext()) );

        //ME CREO UN ADAPTER Y LE PASO COMO PARAMETRO EL array DE rooms QUE YA ESTA LLENO!!!
        final HomeAdapter adapter = new HomeAdapter(listaRooms);

        //CONECTO AL RECYCLERVIEW con el ADAPTER
        recyclerRooms.setAdapter(adapter);

        adapter.setOnClickListener(


                new View.OnClickListener() {

                    @Override
                    public void onClick( View v ) {


                        //PARECE QUE TODO LO QUE HACEMOS EN UN CLICK, NADA SE GUARDA!!
                        // PARECE QUE ESTO SUCEDE PORQUE CADA VEZ QUE VOY Y VENGO, LA ACTIVIDAD SE DESTRUYE

                        //listaRooms.get( recyclerRooms.getChildAdapterPosition( v )  ).setName("DAVOR");

                        //ESTO ES PARA ASEGURARNOS QUE EL RECYCLER VIEW ACTUALICE LA INFO, Y LOS CAMBIOS SE VEAN REFLEJADOS EN PANTALLA
                        //adapter.notifyDataSetChanged();


                        Toast.makeText(getContext(), "Room Selected: " + listaRooms.get( recyclerRooms.getChildAdapterPosition( v )  ).getName(), Toast.LENGTH_SHORT).show();
                    }
                }

        );


        //////ESTAMOS HACIANDO EL BOTON DE CREAR ROOM////////////////////////////
        context = getContext() ;

        createRoomButton = root.findViewById(R.id.create_room);

        if (createRoomButton != null) {
            createRoomButton.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    //openCreateRoomDialog();

                    //CUANDO HACE CLICK EN CREAR ROOM, ME GUSTARIA QUE
                    openCreateRoomDialog();
                    //PARECE QUE TODO LO QUE HACEMOS EN UN CLICK, NADA SE GUARDA!!
                    // PARECE QUE ESTO SUCEDE PORQUE CADA VEZ QUE VOY Y VENGO, LA ACTIVIDAD SE DESTRUYE

                    adapter.notifyDataSetChanged();



                    // La funcion addRoom dentro de API devuelve el id del request que le mando
                    // La api me carga la respuesta en el listener, adecuado.(LLAMA AL LISTENER ADECUADO: RESPUESTA, o ERROR)

                   requestTag = Api.getInstance(context).addRoom(room, new Response.Listener<Room>() {

                        //PARAM 2
                        @Override
                        public void onResponse(Room response) {
                            room.setId(response.getId());
                            resultTextView.setText("Room: " + room.toString());
                            toggleButtons(true);

                            //listaRooms.add(room);

                        }
                        //PARAM 3
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            handleError(error);
                        }

                    });
                }//cierra click


            });//cierra onClickListener
        }

        ////////////////////////////////////////////////////////////////////////////////////

        return root;


    }//CIERRA el OnCreate


    private void llenarlistaRooms() {
        listaRooms.add(new Room("gero", "maspero", R.drawable.garage));
    }



    public void openCreateRoomDialog(){

        CreateRoomDialog theRoomDialog = new CreateRoomDialog() ;
        theRoomDialog.setTargetFragment(HomeFragment.this , 1);
        theRoomDialog.show( getFragmentManager() , "room dialog");

    }





    @Override
    public void applyTexts(String theRoomName) {
        listaRooms.add(new Room(theRoomName , "actualmente 0 dispositivos ", R.drawable.garage));
    }


    private void handleError(VolleyError error) {


        Error response = null;
        Boolean handled = false;


        NetworkResponse networkResponse = error.networkResponse;
        if ((networkResponse != null) && (error.networkResponse.data != null)) {
            try {
                String json = new String(
                        error.networkResponse.data,
                        HttpHeaderParser.parseCharset(networkResponse.headers));

                JSONObject jsonObject = new JSONObject(json);
                json = jsonObject.getJSONObject("error").toString();

                Gson gson = new Gson();
                response = gson.fromJson(json, Error.class);
                handled = true;
            } catch (JSONException e) {
            } catch (UnsupportedEncodingException e) {
            }
        }



        if (handled) {
           //String text = getResources().getString(R.string.error_message);
            String text = "Error";
            if (response != null)
               // text += " " + response.getDescriptione().get(0);

            Toast.makeText( getContext(), text, Toast.LENGTH_LONG).show();
        }

        else
            Log.e(LOG_TAG, error.toString());


    }







    private void toggleButtons(boolean enabled) {
        createRoomButton.setEnabled(!enabled);
    }


}