package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class operaciones extends AppCompatActivity {
    EditText n1,n2,b;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        n1=(EditText)findViewById(R.id.editText2);
        n2 =(EditText)findViewById(R.id.editText5);
        b =(EditText)findViewById(R.id.editText6);
        resultado=(TextView)findViewById(R.id.textView6) ;

    }
    int ainteger(String n){
        return Integer.parseInt(n);
    }
    long along(String n){
        return Long.parseLong(n);
    }
    String astringlog(long n){
        return String.valueOf(n);
    }
    String astringint(int n){
        return String.valueOf(n);
    }
    String decodificar(char n){
        String n2=n+"";
        if ((n=='A') || (n=='a'))
            n2="10";
        if ((n=='B')|| (n=='b'))
            n2="11";
        if ((n=='C')|| (n=='c'))
            n2="12";
        if ((n=='D')|| (n=='d'))
            n2="13";
        if ((n=='E')|| (n=='e'))
            n2="14";
        if ((n=='F')|| (n=='f'))
            n2="15";
        return n2;
    }
    long potencia(int base,int exp){
        long res=1;
        int i=1;
        while (i<=exp){
            res=res*base;
            i++;
        }
        return res;
    }
    //convertir decimal a base
    String abase(String n1,String  b1){
        String a="0123456789ABCDEF";
        String resultado="";
        long n=Long.parseLong(n1);
        long b=Long.parseLong(b1);
        while (n>0) {
            //  String truco=n%b+""; otro metodo a string
            String truco=String.valueOf(n%b);
            int dig =ainteger(truco);
            n=n/b;
            resultado=a.charAt(dig)+resultado;
        }
        return resultado;
    }
    String adecimal(String n1,String b1){
        int k=n1.length();
        long nu=0;
        int i=0;
        while (k>0) {
            int dig=ainteger(decodificar(n1.charAt(k-1))) ;
            long val=dig*potencia(ainteger(b1),i);
            nu=nu+val;
            i++;
            k--;
        }
        return astringlog(nu) ;
    }
    String suma(String n1,String n2,String b){
        String n11=adecimal(n1,b);
        String n22=adecimal(n2,b);
        long r=along(n11)+along(n22);
        String res=abase(astringlog(r),b);
        return res;
    }
    String resta(String n1,String n2,String b){
        String n11=adecimal(n1,b);
        String n22=adecimal(n2,b);
        Long r=along(n11)-along(n22);
        String res=abase(astringlog(r),b);
        return res;
    }
    String multiplicacion(String n1,String n2,String b){
        String n11=adecimal(n1,b);
        String n22=adecimal(n2,b);
        Long r=along(n11)*along(n22);
        String res=abase(astringlog(r),b);
        return res;
    }
    String division(String n1,String n2,String b){
        String n11=adecimal(n1,b);
        String n22=adecimal(n2,b);
        Long r=along(n11)/along(n22);
        String res=abase(astringlog(r),b);
        return res;
    }
    //botones


    public void Suma(View view){
        String numero1=n1.getText().toString()+"" ;
        String numero2=n2.getText() .toString()+"" ;
        String base=b.getText() .toString() +"";
        String result ="ERROR";
        if ((numero1!="")&(numero2!="")&(base!=""))
            if ((ainteger(base)>1)&(ainteger(base)<17))
                result=suma(numero1,numero2,base);
        resultado.setText(result);
    }
    public void Resta(View view){
        String numero1=n1.getText().toString()+"" ;
        String numero2=n2.getText() .toString()+"" ;
        String base=b.getText() .toString() +"";
        String result ="ERROR";
        if ((numero1!="")&(numero2!="")&(base!=""))
            if ((ainteger(base)>1)&(ainteger(base)<17))
                result=resta(numero1,numero2,base);
        resultado.setText(result);
    }
    public void Multiplicacion(View view){
        String numero1=n1.getText().toString()+"" ;
        String numero2=n2.getText() .toString()+"" ;
        String base=b.getText() .toString() +"";
        String result ="ERROR";
        if ((numero1!="")&(numero2!="")&(base!=""))
            if ((ainteger(base)>1)&(ainteger(base)<17))
                result=multiplicacion(numero1,numero2,base) ;
        resultado.setText(result);
    }
    public void Division(View view){
        String numero1=n1.getText().toString()+"" ;
        String numero2=n2.getText() .toString()+"" ;
        String base=b.getText() .toString() +"";
        String result ="ERROR";
        if ((numero1!="")&(numero2!="")&(base!=""))
            if ((ainteger(base)>1)&(ainteger(base)<17))
                result=division(numero1,numero2,base) ;
        resultado.setText(result);
    }
}
