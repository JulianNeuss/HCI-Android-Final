package com.example.hciandroid.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hciandroid.R;
import com.example.hciandroid.Model.Room.Room;

import java.util.ArrayList;



public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> implements View.OnClickListener {




    ////////// P R O P I E D A D E S ////////////////////////////

    ArrayList<Room> listaRooms;

    private View.OnClickListener listener;


    ////////////////////////////////////////////////////////////






    /////////////////// C O N S T R U C T O R ////////////////////
    public HomeAdapter(ArrayList<Room> listaRooms   ) {

        this.listaRooms = listaRooms;

    }
    ////////////////////////////////////////////////////////////////







    ///////////////////// M E T O D O S   ///////////////////////////////////



    //LOS PASOS SERIAN ESTOS:
    //1) DEFINO CUAL ES EL XML QUE ME IMPORTA
    //2) ME CREO UNA INNER CLASS CON PROPIEDADES QUE REPRESENTAN A CADA UNO DE LOS OBJETOS QUE ME INTERESAN DE ESE XML
    //3) A ESAS PORPIEDADES MENCIONADAS EN EL PUNTO ANTERIOR LAS CARGO CON VALORES! ESOS VALORES SON LOS TRAJE COMO PARAMETROS DEL CONSTRUCTOR DE LA CLASE ADAPTER

    // PARA VER GRAFICAMENTE DE QUE ME SIRVE TODO ESTO:
    //   XML <---> InnerClass+Propiedades <--- valores a esas propiedes





    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //ESTO INFLA EL XML!!!!
        //ME AVISA QUE ESTOY LABURANDO CON ESTE XML, Y A SU VEZ, MAS ABAJO SE QUE OBJETOS ME INTERESAN DE ESTE XML.(item_list)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null , false);



        //ESTO QUE ESTA ACA ES PARA EL CLICK
        view.setOnClickListener(this);



        //Notar como le mando un VIEW como parametro. No cualquier view, sino que: view   ---> que sale de "ITEM_LIST.xml"
        return new HomeViewHolder(view);


    }





    // el nombre de este metodo lo dice todo
    //lo que hace es ponerle dinamicamente valores a las propiedades que declare en la inner class
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {


        //NOTAR QUE COMO PARAMETRO RECIBI UNA INSTANCIA DE: HomeViewHolder, que tiene 3 propiedades en este caso!!!


        //ME ESTA LLENANDO LOS OBJETOS QUE ME INTERESAN CON LA INFO DEL ARRAY!!!
        //  ARRAY--->ROOM--->NOMBRE-DEL-ROOM
        holder.txtNombre.setText(   listaRooms.get(position).getName()    );

        holder.txtInformacion.setText(   listaRooms.get(position).getInfo()    );

        holder.foto.setImageResource(   listaRooms.get(position).getImageId()    );

    }





    //es para que el adapter sepa que tamanio tiene el array
    @Override
    public int getItemCount() {

        return listaRooms.size();

    }



    //////////////////////// METODOS PARA EL CLICK LISTENER  ////////////////////////

    public void setOnClickListener(View.OnClickListener listener){

        this.listener = listener ;

    }


    @Override
    public void onClick(View v) {


        if(listener != null ){

            listener.onClick(v);
        }
    }

    //////////////////////////////////////////////////////////////////////////////








    /////////////////// I N N E R    C L A S S ////////////////////
    //////////////////////////////////////////////////////////////

    public class HomeViewHolder extends RecyclerView.ViewHolder {



        //ME QUEDO CON LOS OBJETOS QUE ME INTERESAN DE item_list
        //(ES COMO QUE DESARMO TODO EL XML EN PEDACITOS)
        // Basicamente ES COMO PASAR DE UN XML A LOS OBJETOS QUE ME INTERESAN de ese xml, y en el formato que tienen esos objetos.
        TextView txtNombre;
        TextView txtInformacion;
        ImageView foto;



        //Notar que el constructor recibe como parametro un VIEW
        //en este caso, ese view que viene como parametro esta cargado con el "ITEM_LIST.xml"
        public HomeViewHolder(@NonNull View itemView) {


            super(itemView);


            //Notar que estos ID's, son los que estan en el "ITEM_LIST.xml" !!!
            //te cargo a cada propiedad con los objetos de "ITEM_LIST.xml" que me interesen
            txtNombre = (TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);

            //hasta ahora ya se que cada una de esas propiedades esta linkeada con un objeto de "ITEM_LIST.xml"

        }
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////





}
