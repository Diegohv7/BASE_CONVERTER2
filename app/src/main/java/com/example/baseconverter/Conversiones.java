package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Conversiones extends AppCompatActivity {
    EditText n, ba, bs, bits;
    TextView resultado;
    Converter nro;

    //  Button convertir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversiones);
        n = (EditText) findViewById(R.id.editText);
        ba = (EditText) findViewById(R.id.editText3);
        bs = (EditText) findViewById(R.id.editText4);
        resultado = (TextView) findViewById(R.id.textView3);
        bits = (EditText) findViewById(R.id.editText8);
        nro = new Converter();
    }

    //conversion
    public void convertir(View view) {
        String numero = n.getText().toString() + "";
        String base1 = ba.getText().toString() + "";
        String base2 = bs.getText().toString() + "";
        String result = "ERROR";
        if ((numero != "") & (base1 != "") & (base2 != "")) {
            if ((nro.VerifAllNumberOrLetter(numero, base1)) && ((numero.charAt(0) != '-') & (nro.ainteger(base1) > 1) & (nro.ainteger(base1) < 17) & (nro.ainteger(base2) > 1) & (nro.ainteger(base2) < 17))) {
                if (!nro.VerifMayorNumberOnBase(numero, base1)) {
                    if (!nro.VerifLetter(numero, base1)) {
                        result = nro.conversion(numero, base1, base2);
                        resultado.setText(result);
                    } else {
                        Toast.makeText(getBaseContext(), "NOT PERMITTED LETTERS ON THIS BASE", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "THE NUMBER " + numero + " IS NOT PERMITTED ON BASE " + base1, Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
                Toast.makeText(getBaseContext(), "DO NOT LEAVE BLANK SPACES", Toast.LENGTH_LONG).show();
            }
        }


    public void convertirnegativo(View view) {
        String numero = n.getText().toString() + "";
        String base1 = ba.getText().toString() + "";
        String base2 = bs.getText().toString() + "";
        String bit = bits.getText().toString() + "";
        String result = "";
        if ((numero != "") & (base1 != "") & (base2 != "") & (bit != "")) {
        if ((!nro.VerifPunto(numero))) {
                if (nro.VerifAllNumberOrLetter(numero, base1) && ((nro.ainteger(base1) > 1) & (nro.ainteger(base1) < 17) & (nro.ainteger(base2) > 1) & (nro.ainteger(base2) < 17) & (nro.ainteger(bit) < 61))) {
                    if ((nro.ainteger(base1) > 1) & (nro.ainteger(base1) < 17) & (nro.ainteger(base2) > 1) & (nro.ainteger(base2) < 17) & (nro.ainteger(bit) < 61)) {
                        if (!nro.VerifMayorNumberOnBase(numero, base1)) {
                           if (!nro.VerifLetter(numero, base1)) {
                        if ((numero.charAt(0)) == '-')
                            numero = nro.limpiar(numero);
                                result = nro.convertirnegativo(numero, base1, base2, bit);
                                resultado.setText(result);
                            }else{
                                Toast.makeText(getBaseContext(), "NOT PERMITTED LETTERS ON THIS BASE", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getBaseContext(), "THE NUMBER " + numero + " IS NOT PERMITTED ON BASE " + base1, Toast.LENGTH_LONG).show();
                        }
                    } else
                        Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
                } else if (bit == "")
                    Toast.makeText(getBaseContext(), "ENTER THE QUANTITY OF BITS FOR THE NEGATIVE NUMBER", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            } else {
            Toast.makeText(getBaseContext(), "NOT PERMITTED NEGATIVE FRACTIONAL NUMBERS", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "DO NOT LEAVE BLANK SPACES", Toast.LENGTH_LONG).show();
        }
        }
}
