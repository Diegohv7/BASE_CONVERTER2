package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class operaciones extends AppCompatActivity {
    EditText n1,n2,b;
    TextView resultado;
    Converter nro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        n1=(EditText)findViewById(R.id.editText2);
        n2 =(EditText)findViewById(R.id.editText5);
        b =(EditText)findViewById(R.id.editText6);
        nro=new Converter();
        resultado=(TextView)findViewById(R.id.textView6) ;
    }

    //botones

    public void Suma(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String result;
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                result = nro.suma(numero1, numero2, base);
                resultado.setText(result);
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
    }
    public void Resta(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String result;
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                result = nro.resta(numero1, numero2, base);
                resultado.setText(result);
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
    }
    public void Multiplicacion(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String result = "ERROR";
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                result = nro.multiplicacion(numero1, numero2, base);
                resultado.setText(result);
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
    }
    public void Division(View view){
        String numero1=n1.getText().toString()+"" ;
        String numero2=n2.getText() .toString()+"" ;
        String base=b.getText() .toString() +"";
        String result ="ERROR";
        if ((numero1!="")&(numero2!="")&(base!="")){
            if ((nro.ainteger(base)>1)&(nro.ainteger(base)<17)) {
                result = nro.division(numero1, numero2, base);
                resultado.setText(result);
            }else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
    }
}
