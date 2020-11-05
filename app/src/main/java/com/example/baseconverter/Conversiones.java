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
  //  Button convertir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversiones);
        n=(EditText)findViewById(R.id.editText);
        ba =(EditText)findViewById(R.id.editText3);
        bs =(EditText)findViewById(R.id.editText4);
        resultado=(TextView)findViewById(R.id.textView3) ;
        //convertir=(Button)findViewById(R.id.button2);
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
    //convertir a decimal
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
    //convertir base a base
    String conversion(String n1,String b1,String b2){
        if (ainteger(b1) !=10)
            n1=adecimal(n1,b1);
            return abase(n1,b2);
    }
    int buscar(String n1){
        int l=n1.length();
        int pos=0;
        boolean b=true;
        String n2="";
        while ((l>0)&(b)){
            if (n1.charAt(l-1)=='1') {
                pos = l;
                b=false;
            }
            l--;
        }
        return pos;
    }
    String ceros(String n1){
        int l=16-n1.length();
        String n2=n1;
        while (l>0){
                n2='0'+n2;
            l--;
        }
        return n2;
    }
    //complemeanto a 2
    String complemento(String n1){
        n1=ceros(n1);
        int l=n1.length();
        String n2="";
        int pos=buscar(n1);
        while (l>0){
                if (l < pos) {
                    n2=(n1.charAt(l-1)=='1')?'0'+n2:'1'+n2;
                } else
                    n2 = n1.charAt(l - 1) + n2;
            l--;
        }
        return n2;
    }

    String convertircomplemento(String n1,String b1,String b2){
        if (b1!="10")
            n1=adecimal(n1,b1);
        n1=abase(n1,"2");
        n1=complemento(n1);
        if (b2!="2") {
            n1=adecimal(n1,"2");
            n1 = abase(n1, b2);
        }
        return n1;
       // return n1;
    }
    String limpiar(String n1){
        int l=n1.length();
        String n2="";
        while (l>1){
            n2=n1.charAt(l-1)+n2;
            l--;
        }
        return n2;
    }
    //conversion
    public void convertir(View view){
        String numero=n.getText().toString()+"" ;
        String base1=ba.getText() .toString()+"" ;
        String base2=bs.getText() .toString() +"";
        String result ="ERROR";
        if ((numero!="")&(base1!="")&(base2!=""))
            if ((ainteger(base1)>1)&(ainteger(base1)<17)&(ainteger(base2)>1)&(ainteger(base2)<17))
                result=conversion(numero,base1,base2);
        resultado .setText(result);
    }

    public void convertirnegativo(View view){
        String numero=n.getText().toString()+"" ;
        String base1=ba.getText() .toString()+"" ;
        String base2=bs.getText() .toString() +"";
        String result ="ERROR";
        if ((numero!="")&(base1!="")&(base2!="")) {
            if ((ainteger(base1) > 1) & (ainteger(base1) < 17) & (ainteger(base2) > 1) & (ainteger(base2) < 17)) {
                if ((numero.charAt(0)) == '-')
                    numero = limpiar(numero);
                result = convertircomplemento(numero, base1, base2) ;
            }
        }
        if (ainteger(base2)==10)
            result ='-'+result;
        resultado .setText(result);
    }
}
