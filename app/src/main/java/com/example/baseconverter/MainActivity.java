package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //llamar a activity conversiones
    public void Siguiente(View view){
        Intent siguiente=new Intent(this, Conversiones .class ) ;
        startActivity(siguiente);
    }
    //llamar a activity operaciones
    public void Siguiente2(View view){
        Intent siguiente2=new Intent(this, operaciones  .class ) ;
        startActivity(siguiente2);
    }
}
