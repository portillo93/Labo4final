package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    ArrayList<informa> array = new ArrayList<informa>();
    informa Sol;
    informa Mercurio;
    informa Marte;
    informa Venus;
    informa Tierra;
    informa Jupiter;
    informa Saturno;
    informa Neptuno;
    informa Urano;

    private String[] Nombres;
    private String[] Foto;
    private String[] Distancia;
    private String[] Satelites;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        Nombres = getResources().getStringArray(R.array.Planetas);
        Foto =  getResources().getStringArray(R.array.Images);
        Distancia = getResources().getStringArray(R.array.distancia);
        Satelites = getResources().getStringArray(R.array.satelites);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planetas, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
        informa InfoPlanet = new informa(Nombres[i],Foto[i],Distancia[i],Satelites[i]);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            Bundle bundle= new Bundle();
            bundle.putSerializable("Key",InfoPlanet);

            Toast.makeText(getActivity(), " " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            newIntent.putExtras(bundle);



            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), " " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putSerializable("Key",InfoPlanet);
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);
            final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
