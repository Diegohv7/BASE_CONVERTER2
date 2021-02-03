package apps.ejemplos.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import apps.ejemplos.baseconverter.R;

public class operaciones extends AppCompatActivity {
    EditText n1,n2,b,bits;
    TextView resultado;
    Converter nro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        n1=(EditText)findViewById(R.id.editText2);
        n2 =(EditText)findViewById(R.id.editText5);
        b =(EditText)findViewById(R.id.editText6);
        //bits=(EditText)findViewById(R.id.editText7);
        nro=new Converter();
        resultado=(TextView)findViewById(R.id.textView6) ;
    }

    //botones
    boolean VerifCaracter(String n1){
        String s="-0123456789ABCDEFabcdef";
        boolean b=true;
        int d=0;
        int i=0;
        while (i<n1.length()&b){
            if (s.indexOf(n1.charAt(i))==-1)
                b=false;
            else if (n1.charAt(i)=='-')
                d++;
            i++;
        }
        return b &((d==0)|(d==1));
    }
    boolean EnabledOperation(String n1,String b1){
        boolean b=true;
        int i=0;
        while (i<n1.length() & b & VerifCaracter(n1)){
            if ((n1.charAt(i)!='-')) {
                int k = nro.ainteger(nro.decodificar(n1.charAt(i)));
                if (k >= nro.ainteger(b1))
                    b = false;
            }
            i++;
        }
        return b & VerifCaracter(n1);
    }
    public void Suma(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String bit="";
        String result="";
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((EnabledOperation(numero2,base))&(EnabledOperation(numero1,base))& (nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                if ((numero1.charAt(0)!='-')&(numero2.charAt(0)!='-'))
                    result = nro.suma(numero1, numero2, base,bit);
                else
                    Toast.makeText(getBaseContext(), "NOT PERMITTED NEGATIVE NUMBERS", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
        resultado.setText(result);
    }
    public void Resta(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String bit="";
        String result="";
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((EnabledOperation(numero2,base))&(EnabledOperation(numero1,base))& (nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                if ((numero1.charAt(0)!='-')&(numero2.charAt(0)!='-'))
                    result = nro.resta(numero1, numero2, base,bit);
                else
                    Toast.makeText(getBaseContext(), "NOT PERMITTED NEGATIVE NUMBERS", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
        resultado.setText(result);
    }
    public void Multiplicacion(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String bit="";
        String result="";
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((EnabledOperation(numero2,base))&(EnabledOperation(numero1,base))& (nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                if ((numero1.charAt(0)!='-')&(numero2.charAt(0)!='-'))
                    result = nro.multiplicacion(numero1, numero2, base,bit);
                else
                    Toast.makeText(getBaseContext(), "NOT PERMITTED NEGATIVE NUMBERS", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
        resultado.setText(result);
    }
    public void Division(View view) {
        String numero1 = n1.getText().toString() + "";
        String numero2 = n2.getText().toString() + "";
        String base = b.getText().toString() + "";
        String bit = "";
        String result = "";
        if ((numero1 != "") & (numero2 != "") & (base != "")) {
            if ((EnabledOperation(numero2, base)) & (EnabledOperation(numero1, base)) & (nro.ainteger(base) > 1) & (nro.ainteger(base) < 17)) {
                if ((numero1.charAt(0) != '-') & (numero2.charAt(0) != '-'))
                    result = nro.division(numero1, numero2, base,bit);
                else
                    Toast.makeText(getBaseContext(), "NOT PERMITTED NEGATIVE NUMBERS", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getBaseContext(), "PLEASE ENTER THE DATA CORRECTLY", Toast.LENGTH_LONG).show();
        }
        resultado.setText(result);
    }
}
