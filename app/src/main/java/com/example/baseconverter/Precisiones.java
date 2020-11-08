package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Precisiones extends AppCompatActivity {
      EditText nu,ba;
      TextView sig,exp,man,res1,res2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precisiones);
        nu=(EditText)findViewById(R.id.edt9);
        ba=(EditText)findViewById(R.id.edt10);
        sig=(TextView)findViewById(R.id.textView18);
        exp=(TextView)findViewById(R.id.textView19);
        man=(TextView)findViewById(R.id.textView20);
        res1=(TextView)findViewById(R.id.textView23);
        res2=(TextView)findViewById(R.id.textView24);
    }


    //botones
    public void SimplePresicion(View view){
        String numero = nu.getText().toString()+"";
        String base = ba.getText().toString()+"";
        String result = "ERROR";

    }

}