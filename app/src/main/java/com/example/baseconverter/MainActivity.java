package com.example.baseconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.soporte) {
            Toast.makeText(this, "Soporte", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.contactanos) {
            Toast.makeText(this, "Contactanos", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.reporte) {
            Toast.makeText(this, "Reporte", Toast.LENGTH_SHORT).show();
        }
    return true;
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
    //llamar a la activity presiciones
    public void Siguiente3(View view) {
      Intent siguiente3=new Intent( this, Precisiones.class);
      startActivity(siguiente3);
    }
}
