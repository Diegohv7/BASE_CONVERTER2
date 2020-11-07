package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Conversiones extends AppCompatActivity  {
    EditText n,ba,bs;
    TextView resultado;
    Converter nro;
  //  Button convertir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversiones);
        n=(EditText)findViewById(R.id.editText);
        ba =(EditText)findViewById(R.id.editText3);
        bs =(EditText)findViewById(R.id.editText4);
        resultado=(TextView)findViewById(R.id.textView3) ;
        nro=new Converter();
        //convertir=(Button)findViewById(R.id.button2);
    }

    //conversion
    public void convertir(View view){
        String numero=n.getText().toString()+"";
        String base1=ba.getText() .toString()+"" ;
        String base2=bs.getText() .toString() +"";
        String result ="ERROR";
        if ((numero!="")&(base1!="")&(base2!=""))
            if ((nro.ainteger(base1)>1)&(nro.ainteger(base1)<17)&(nro.ainteger(base2)>1)&(nro.ainteger(base2)<17))
                result=nro.conversion(numero,base1,base2);
        resultado .setText(result);
    }

    public void convertirnegativo(View view){
        String numero=n.getText().toString()+"" ;
        String base1=ba.getText() .toString()+"" ;
        String base2=bs.getText() .toString() +"";
        String result ="ERROR";
        if ((numero!="")&(base1!="")&(base2!="")) {
            if ((nro.ainteger(base1) > 1) & (nro.ainteger(base1) < 17) & (nro.ainteger(base2) > 1) & (nro.ainteger(base2) < 17)) {
                if ((numero.charAt(0)) == '-')
                    numero = nro.limpiar(numero);
                result = nro.convertirnegativo(numero, base1, base2) ;
            }
        }
            result ='-'+result;
        resultado .setText(result);
    }
}
