package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.MalformedInputException;

public class Precisiones extends AppCompatActivity { //implements View.OnClickListener {
    EditText nu, ba;
    TextView sig, exp, man, hexa, dec, bit1, bit2, bit3, bit4, bit5;
    Converter nro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precisiones);
        nu = (EditText) findViewById(R.id.edt9);
        ba = (EditText) findViewById(R.id.edt10);
        sig = (TextView) findViewById(R.id.textView18);
        exp = (TextView) findViewById(R.id.textView19);
        man = (TextView) findViewById(R.id.textView20);
        hexa = (TextView) findViewById(R.id.textView23);
        dec = (TextView) findViewById(R.id.textView24);
        bit1 = (TextView) findViewById(R.id.textView112);
        bit2 = (TextView) findViewById(R.id.textView14);
        bit3 = (TextView) findViewById(R.id.textView113);
        bit4 = (TextView) findViewById(R.id.textView12);
        bit5 = (TextView) findViewById(R.id.textView114);
        nro = new Converter();
    }
    //botones
    public void SimplePresicion(View view) {
        String numero = nu.getText().toString() + "";
        String base = ba.getText().toString() + "";
        String mantisa = "";
        String exponente = "";
        String signo = "0";
        String hexadecimal = "";
        String decimal = "";
        boolean b=true;
        int j1 = 0;
        String j="";
        if ((numero != "") && (base != "")) {
            if((numero.charAt(0)) == '-'){
                numero = nro.limpiar(numero);
                signo="1";
            }
            if ((nro.Enabled(numero, base)) && ((nro.ainteger(base) > 1) && (nro.ainteger(base) < 17))) {
        if (nro.VerifPunto(numero)) {
                    decimal = nro.conversion(nro.ParteEntera(numero), base, "2");
                    j=nro.SimplePrecisionMan1(nro.conversion(numero, base, "2"));
        }
        else{
            decimal = nro.conversion(numero, base, "2");
            b=false;
        }
        int k = decimal.length();
                    mantisa = nro.conversion(numero, base, "2");
                    exponente = nro.conversion(numero, base, "2");
                mantisa = nro.SimplePrecisionMan(mantisa);
                exponente = nro.SimplePrecisionExp(exponente);


                bit2.setVisibility(View.VISIBLE);
                bit4.setVisibility(View.VISIBLE);
                bit3.setVisibility(View.GONE);
                bit5.setVisibility(View.GONE);
                bit1.setVisibility(View.VISIBLE);

                if (mantisa != "") {
                    mantisa=mantisa.substring(0,23);
                    man.setText(mantisa);
                    exponente=exponente.substring(0,8) ;
                    exp.setText(exponente);
                    sig.setText(signo);
                    hexadecimal = nro.PrecisionSimpleHexa(signo, exponente, mantisa);
                    hexa.setText(hexadecimal);
                    if (b)
                        if (j!="")
                            decimal = decimal + "."+ j + mantisa.substring(k - 1);
                        else
                        decimal = decimal + "." + mantisa.substring(k - 1);
                        decimal = nro.conversion(decimal, "2", "10");
                    if (signo=="1")
                        decimal="-"+decimal;
                        dec.setText(decimal );
                } else {
                    Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "DO NOT LEAVE BLANK SPACES", Toast.LENGTH_LONG).show();
        }
    }

    public void DoblePresicion(View view) {
        String numero = nu.getText().toString() + "";
        String base = ba.getText().toString() + "";
        String mantisa = "";
        String exponente = "";
        String signo = "0";
        String hexadecimal = "";
        String decimal = "";
        boolean b=true;
        int j1 = 0;
        String j="";
        if ((numero != "") && (base != "")) {
            if(numero.charAt(0) == '-'){
                numero = nro.limpiar(numero);
                signo="1";
            }
            if ((nro.Enabled(numero, base)) && ((nro.ainteger(base) > 1) && (nro.ainteger(base) < 17))) {
            if (nro.VerifPunto(numero)) {
                decimal = nro.conversion(nro.ParteEntera(numero), base, "2");
                j=nro.SimplePrecisionMan1(nro.conversion(numero, base, "2"));
            }else{
                decimal = nro.conversion(numero, base, "2");
                b=false;
            }
            int k = decimal.length();
                mantisa = nro.conversion(numero, base, "2");
                exponente = nro.conversion(numero, base, "2");
                mantisa = nro.DoblePrecisionMan(mantisa);
                exponente = nro.DoblePrecisionExp(exponente);

                bit3.setVisibility(View.VISIBLE);
                bit5.setVisibility(View.VISIBLE);
                bit2.setVisibility(View.GONE);
                bit4.setVisibility(View.GONE);
                bit1.setVisibility(View.VISIBLE);

                if (mantisa != "") {
                    mantisa=mantisa.substring(0,52);
                    man.setText(mantisa);
                    exponente=exponente.substring(0,11);
                    exp.setText(exponente);
                    sig.setText(signo);
                    hexadecimal = nro.PrecisionSimpleHexa(signo, exponente, mantisa);
                    hexa.setText(hexadecimal);
                    if (b)
                        if (j!="")
                            decimal = decimal + "."+ j + mantisa.substring(k - 1);
                        else
                            decimal = decimal + "." + mantisa.substring(k - 1);
                    decimal = nro.conversion(decimal, "2", "10");
                    if (signo=="1")
                        decimal="-"+decimal;
                    dec.setText(decimal);
                } else {
                    Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "DO NOT LEAVE BLANK SPACES", Toast.LENGTH_LONG).show();
        }
    }
}



