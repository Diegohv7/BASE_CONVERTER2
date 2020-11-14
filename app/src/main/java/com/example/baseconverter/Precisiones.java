package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
       // findViewById(R.id.button10).setOnClickListener(this);
       // findViewById(R.id.button11).setOnClickListener(this);
    }

    //botones
    public void SimplePresicion(View view) {
        String numero = nu.getText().toString() + "";
        String base = ba.getText().toString() + "";
        String result = "ERROR";
        String mantisa = "";
        String exponente = "";
        String signo = "";
        String hexadecimal="";
        String decimal="";
        if ((numero != "") && (base != "")) {
            if ((nro.ainteger(base) > 1) && (nro.ainteger(base) < 17)) {
                if ((numero.charAt(0)) != '-') {
                    mantisa = nro.conversion(numero, base, "2");
                    exponente = nro.conversion(numero, base, "2");
                    signo = "0";
                } else {
                    numero = nro.limpiar(numero);
                    mantisa = nro.conversion(numero, base, "2");
                    exponente = nro.conversion(numero, base, "2");
                    signo = "1";
                }
                mantisa = nro.SimplePrecisionMan(mantisa, base);
                exponente = nro.SimplePrecisionExp(exponente, base);
            }
            bit2.setVisibility(View.VISIBLE);
            bit4.setVisibility(View.VISIBLE);
            bit3.setVisibility(View.GONE);
            bit5.setVisibility(View.GONE);
            bit1.setVisibility(View.VISIBLE);
        }
        if (mantisa != "") {
            man.setText(mantisa);
            exp.setText(exponente);
            sig.setText(signo);
            hexadecimal=nro.PrecisionHexa(signo, exponente, mantisa);
            hexa.setText(hexadecimal);
            decimal=nro.conversion(hexadecimal,"16", "10");
            dec.setText(decimal);
        } else {
            sig.setText(result);
            exp.setText(result);
            man.setText(result);
        }
    }
    public void DoblePresicion(View view) {
        String numero = nu.getText().toString() + "";
        String base = ba.getText().toString() + "";
        String result = "ERROR";
        String mantisa = "";
        String exponente = "";
        String signo = "";
        if ((numero != "") && (base != "")) {
            if ((nro.ainteger(base) > 1) && (nro.ainteger(base) < 17)) {
                if ((numero.charAt(0)) != '-') {
                    mantisa = nro.conversion(numero, base, "2");
                    exponente = nro.conversion(numero, base, "2");
                    signo = "0";
                } else {
                    numero = nro.limpiar(numero);
                    mantisa = nro.conversion(numero, base, "2");
                    exponente = nro.conversion(numero, base, "2");
                    signo = "1";
                }
                mantisa = nro.DoblePrecisionMan(mantisa, base);
                exponente = nro.DoblePrecisionExp(exponente, base);
            }
            bit3.setVisibility(View.VISIBLE);
            bit5.setVisibility(View.VISIBLE);
            bit2.setVisibility(View.GONE);
            bit4.setVisibility(View.GONE);
            bit1.setVisibility(View.VISIBLE);
        }
        if (mantisa != "") {
            man.setText(mantisa);
            exp.setText(exponente);
            sig.setText(signo);

        } else {
            sig.setText(result);
            exp.setText(result);
            man.setText(result);
        }
    }
}
    /*@Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button10:
                    bit2.setVisibility(View.VISIBLE);
                    bit4.setVisibility(View.VISIBLE);
                    bit3.setVisibility(View.GONE);
                    bit5.setVisibility(View.GONE);
                    bit1.setVisibility(View.VISIBLE);
                break;
            case R.id.button11:
                    bit3.setVisibility(View.VISIBLE);
                    bit5.setVisibility(View.VISIBLE);
                    bit2.setVisibility(View.GONE);
                    bit4.setVisibility(View.GONE);
                    bit1.setVisibility(View.VISIBLE);
                break;
        }
    }*/


