package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text;
    TextView text2;
    TextView text3;
    ImageView Foto;
    Bundle bundle;
    Intent a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text= findViewById(R.id.textId);
        text2= findViewById(R.id.textId2);
        text3= findViewById(R.id.textId3);
        Foto= findViewById(R.id.Img);
        Intent callingIntent = this.getIntent();
        bundle= callingIntent.getExtras();
        informa info = (informa)bundle.getSerializable("Key") ;
        Resources reso =getResources();
        TypedArray Icons = reso.obtainTypedArray(R.array.img);
        Drawable drawable = Icons.getDrawable(Integer.parseInt(info.getImagen()));



        text.setText(info.getNombre());
        Foto.setImageDrawable(drawable);
        text2.setText(info.getDistancia());
        text3.setText(info.getSatelites());
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();


    }

}
