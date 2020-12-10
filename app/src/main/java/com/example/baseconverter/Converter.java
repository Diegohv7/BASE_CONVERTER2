package com.example.baseconverter;

import android.widget.Toast;

public class Converter {
    int ainteger(String n) {
        return Integer.parseInt(n);
    }

    long along(String n) {
        return Long.parseLong(n);
    }

    double adouble(String n) {
        return Double.parseDouble(n);
    }

    String astringlog(long n) {
        return String.valueOf(n);
    }

    String astringint(int n) {
        return String.valueOf(n);
    }

    String astringdouble(double n) {
        return String.valueOf(n);
    }

    //convertir decimal a base b
    String abase(String n1, String b1) {
        String a = "0123456789ABCDEF";
        String resultado = "";
        if (n1.length()<19) {
            long n = Long.parseLong(n1);
            long b = Long.parseLong(b1);
            if (n == 0)
                resultado = "0";
            while (n > 0) {
                //  String truco=n%b+""; otro metodo a string
                String truco = String.valueOf(n % b);
                int dig = ainteger(truco);
                n = n / b;
                resultado = a.charAt(dig) + resultado;
            }
        }else
           return "0";
        return resultado;
    }

    //-123.3232
    String decodificar(char n) {
        String n2 = n + "";
        if ((n == 'A') || (n == 'a'))
            n2 = "10";
        if ((n == 'B') || (n == 'b'))
            n2 = "11";
        if ((n == 'C') || (n == 'c'))
            n2 = "12";
        if ((n == 'D') || (n == 'd'))
            n2 = "13";
        if ((n == 'E') || (n == 'e'))
            n2 = "14";
        if ((n == 'F') || (n == 'f'))
            n2 = "15";
        return n2;
    }

    String codificar(String n) {
        String n2 = n;
        if ((ainteger(n) == 10))
            n2 = "A";
        if (ainteger(n) == 11)
            n2 = "B";
        if (ainteger(n) == 12)
            n2 = "C";
        if (ainteger(n) == 13)
            n2 = "D";
        if (ainteger(n) == 14)
            n2 = "E";
        if (ainteger(n) == 15)
            n2 = "F";
        return n2;
    }

    long potencia(int base, int exp) {
        long res = 1;
        int i = 1;
        while (i <= exp) {
            res = res * base;
            i++;
        }
        return res;
    }

    //convertir a decimal
    String adecimal(String n1, String b1) {
        int k = n1.length();
        long nu = 0;
        int i = 0;
        while (k > 0) {
            int dig = ainteger(decodificar(n1.charAt(k - 1)));
            long val = dig * potencia(ainteger(b1), i);
            if (astringlog(nu).length()<19 )
            nu = nu + val;
            else{
            nu = 0;
            break;}
            i++;
            k--;
        }
        return astringlog(nu);
    }

    //CONVERTIR PARTE FRACCIONARIO (CODIGOS)
    boolean VerifPunto(String n1) {
        boolean b = false;
        byte i = 0;
        while (i < n1.length() & !(b)) {
            if (n1.charAt(i) == '.') {
                b = true;
            }
            i++;
        }
        return b;
    }
    int EncontrarPunto(String n1) {
        int k = 0;
            boolean b = true;
            byte i = 0;
            while (i < n1.length() & b) {
                if (n1.charAt(i) == '.') {
                    k = i;
                    b = false;
                }
                i++;
            }
        return k;
    }
    boolean VerifCaracter(String n1){
        String s="0123456789ABCDEF.";
        boolean b=true;
        int c=0;
        int i=0;
        while (i<n1.length()&b){
            if (s.indexOf(n1.charAt(i))==-1)
                b=false;
            else if ((n1.charAt(i)=='.'))
                c++;
            i++;
        }
        return b & ((c==1)|(c==0));
    }
    boolean Enabled(String n1,String b1){
        boolean b=true;
        int i=0;
        while (i<n1.length() & b & VerifCaracter(n1)){
            if (n1.charAt(i)!='.') {
                int k = ainteger(decodificar(n1.charAt(i)));
                if (k >= ainteger(b1))
                    b = false;
            }
            i++;
        }
        return b & VerifCaracter(n1);
    }
    String ParteEntera(String n1) {
        int k=(VerifPunto(n1))?EncontrarPunto(n1):n1.length();
        return n1.substring(0, k);
    }

    String ParteFraccionaria(String n1) {
        int k=(VerifPunto(n1))?EncontrarPunto(n1)+1:0;
        n1=(k!=0)?n1.substring(k):"";
        return n1;
    }

    //convertir a decimal parte fracionaria
    String adecimalFraccionaria(String n1, String b1) {
        int k = 0;
        double nu = 0;
        if (ainteger(b1) != 10) {
            while (k < n1.length()) {
                int dig = ainteger(decodificar(n1.charAt(k)));
                double val = dig * (1d / potencia(ainteger(b1), k + 1));
                nu = nu + val;
                k++;
            }
        } else
            nu = adouble("0." + n1);
        return astringdouble(nu);
    }
    boolean verifNeg(String n1){
        boolean b=false;
        int i=0;
        while (i<n1.length()&!b){
            if (n1.charAt(i)=='-')
                b=true;
            i++;
        }
        return b;
    }
    int posicionSig(String n1){
        int c=0;
        for (int i=0;(i<n1.length());i++){
            if (n1.charAt(i)=='-')
                    c=i;
        }
        return c;
    }
    String DeletePunto(String n1){
        String n2="";
        for (int i=0;(i<n1.length());i++){
            if (n1.charAt(i)!='.')
                n2=n2+n1.charAt(i);
        }
        return n2;
    }
    String FraccionariaNC(String n1){
        //ej= n1=1.23E-7;=0.000000123
        int n=ainteger(n1.substring(posicionSig(n1)+1))-1;
        String n2="";
        n1=n1.substring(0,posicionSig(n1)-1);//eliminando E-7 seria n1= 1.23
        for (int i=0;(i<n);i++){ //rellenando de 0s
            n2=n2+'0';
        }
        n2=n2+DeletePunto(n1);//eliminando (.)  n2+ n1= 123
        return n2;
    }
    //Convertir decimal fraccionario a otra base       //5.125    b=2
    String abaseFraccionario(String n1, String b1,int bit) {
        n1 = "0." + n1;
        String nt = "0.";
        double nf = adouble(n1);    //0.125
        int k = bit;
        boolean b = true;
        if (ainteger(b1) != 10) {
            while ((k > 0) & b) {  //52 bit de decimales
                nf = nf * ainteger(b1);//0.125*2=0.25
                String pe = (verifNeg(astringdouble(nf)))?"0":ParteEntera(astringdouble(nf));   //pe=0
                nt = nt + codificar(pe);
                String pf = (verifNeg(astringdouble(nf)))?FraccionariaNC(astringdouble(nf)):ParteFraccionaria(astringdouble(nf));   //nf=25
                if (pf == "")
                    b = false;
                nf = adouble("0." + pf);     //nf=0.25
                k--;
            }
        } else
            nt = n1;
        return nt;
    }

    //convertir base a base
    String conversion(String n1, String b1, String b2) {   //F.F1  b1=16   b2=10
        String n2 = "";
        if (VerifPunto(n1)) {    //true
            n2 = ParteFraccionaria(n1);//n2=F1
            n1 = ParteEntera(n1);     //n1=F
            n2 = adecimalFraccionaria(n2, b1);
            n2 = abaseFraccionario(n2.substring(2), b2,32);
        }
        if (ainteger(b1) != ainteger(b2)) {  //true
            if (ainteger(b1) != 10)       //true
                n1 = adecimal(n1, b1);
            n1 = abase(n1, b2);
        }
        if (!n1.equals("") & (VerifPunto(n2)))
            n2 = n2.substring(1);
        return n1 + n2;
    }

    int buscar(String n1) {
        int l = n1.length();
        int pos = 0;
        boolean b = true;
        while ((l > 0) & (b)) {
            if (n1.charAt(l - 1) == '1') {
                pos = l;
                b = false;
            }
            l--;
        }
        return pos;
    }

    String definir_bits(String n1, String bit) {
        int l;
        if (ainteger(bit) > n1.length()) {
            l = ainteger(bit) - n1.length();
            while (l > 0) {
                n1 = '0' + n1;
                l--;
            }
        } else {
            n1 = n1.substring(n1.length() - ainteger(bit));
        }
        return n1;
    }

    //complemeanto a 2
    String complemento(String n1) {
        int l = n1.length();
        String n2 = "";
        int pos = buscar(n1);
        while (l > 0) {
            if (l < pos) {
                n2 = (n1.charAt(l - 1) == '1') ? '0' + n2 : '1' + n2;
            } else
                n2 = n1.charAt(l - 1) + n2;
            l--;
        }
        return n2;
    }

    String convertirnegativo(String n1, String b1, String b2, String bit) {
        if ((ainteger(b1) == 10) | (ainteger(b2) == 10)) {
            n1 = conversion(n1, b1, "2");
            n1 = definir_bits(n1, bit);
            n1 = complemento(n1);
            n1 = conversion(n1, "2", b2);
        } else
            n1 = conversion(n1, b1, b2);
        return n1;
    }

    //copiar caracteres desde una posicion hasta otra cadena2=cadena1.substring(0,2);
    //copiar caracteres desde una posicion hasta el final de la cadena: cadena2=cadena1.substring(posicion);
    String limpiar(String n1) {
        n1 = n1.substring(1);
        return n1;
    }

    //dejar esto
    String suma(String n1, String n2, String b,String bit) {
        String n11;
        String n22;
        String res;
        if (n1.charAt(0)!='-')
            n11 = adecimal(n1, b);
        else
            n11='-'+convertirnegativo(limpiar(n1),b,"10",bit);

        if (n2.charAt(0)!='-')
            n22 = adecimal(n2, b);
        else
            n22='-'+convertirnegativo(limpiar(n2),b,"10",bit);
        if (n11.length()<19 & n22.length()<19 ) {
            Long r = along(n11) + along(n22);
            if (astringlog(r).charAt(0) == '-')
                res = '-' + convertirnegativo(astringlog(r), "10", b, bit);
            else
                res = abase(astringlog(r), b);
        }else
            return "0";
        return res;
    }

    String resta(String n1, String n2, String b,String bit) {
        String n11;
        String n22;
        String res;
        if (n1.charAt(0)!='-')
            n11 = adecimal(n1, b);
        else
            n11='-'+convertirnegativo(limpiar(n1),b,"10",bit);

        if (n2.charAt(0)!='-')
            n22 = adecimal(n2, b);
        else
            n22='-'+convertirnegativo(limpiar(n2),b,"10",bit);
        if (n11.length()<19 & n22.length()<19 ) {
            Long r = along(n11) - along(n22);
            if (ainteger(b) != 10) {
                if (astringlog(r).charAt(0) == '-') {
                    n1 = abase(limpiar(astringlog(r)), "2");
                    bit = astringint(n1.length() + 1);
                    res = '-' + convertirnegativo(limpiar(astringlog(r)), "10", b, bit);
                } else
                    res = abase(astringlog(r), b);
            } else
                res = astringlog(r);
        }else
            return "0";
        return res;
    }

    String multiplicacion(String n1, String n2, String b,String bit) {
        String n11;
        String n22;
        String res;
        if (n1.charAt(0)!='-')
            n11 = adecimal(n1, b);
        else
            n11='-'+convertirnegativo(limpiar(n1),b,"10",bit);

        if (n2.charAt(0)!='-')
            n22 = adecimal(n2, b);
        else
            n22='-'+convertirnegativo(limpiar(n2),b,"10",bit);
        if (n11.length()<19 & n22.length()<19 ) {
            Long r = along(n11) * along(n22);
            if (astringlog(r).charAt(0) == '-')
                res = '-' + convertirnegativo(astringlog(r), "10", b, bit);
            else
                res = abase(astringlog(r), b);
        }else
            return "0";
        return res;
    }

    String division(String n1, String n2, String b,String bit) {
        String n11;
        String n22;
        String res;
        if (n1.charAt(0)!='-')
            n11 = adecimal(n1, b);
        else
            n11='-'+convertirnegativo(limpiar(n1),b,"10",bit);

        if (n2.charAt(0)!='-')
            n22 = adecimal(n2, b);
        else
            n22='-'+convertirnegativo(limpiar(n2),b,"10",bit);
        if (n11.length()<19 & n22.length()<19 ) {
            Long r = along(n11) / along(n22);
            if (astringlog(r).charAt(0) == '-')
                res = '-' + convertirnegativo(astringlog(r), "10", b, bit);
            else
                res = abase(astringlog(r), b);
        }else
            return "0";
        return res;
    }

    String SimplePrecisionMan(String n1) {   //n1 = 1
        int k = 0;
        String n2 = ParteFraccionaria(n1);   //
        String n3 = ParteEntera(n1);        //1
        String nr=n3+n2;                    //nr=1
        k=(posicionOne(n2)==0)?posicionOne(n2):posicionOne(n2)+1;
        if (VerifPunto(n1) & k == 0)
            k++;                                          //k = 1
        if (nr.length()>1 )
        nr=(!n3.equals("0"))?nr.substring(posicionOne(nr)+1):nr.substring(k+1);   //nr = 110
        else
            nr="";
        while (nr.length() < 23) {
            nr = nr+'0';
        }
        return nr;
    }

    int posicionOne(String n1) {
        int pos = 0;
        int i=0;
        //boolean b=false;
        if (n1!="") {
            while ((i < n1.length())) {
                if (n1.charAt(i)=='1') {
                    pos = i;
                    break;
                }
                i++;
            }
        }
            return pos;
    }

    String SimplePrecisionExp(String n1) {
        int k = 0;
        String n2=ParteFraccionaria(n1);
        String n3=ParteEntera(n1);
        k=(!n3.equals("0"))?n3.length()-1:-1*(posicionOne(n2)+1);
        n1 = astringlog((potencia(2, 8 - 1) + k) - 1);
        n1 = conversion(n1, "10", "2");
        while (n1.length() < 8) {
            n1 = "0" + n1;
        }
        return n1;
    }
    String conversionDoble(String n1, String b1, String b2) {   //F.F1  b1=16   b2=10
        String n2 = "";
        if (VerifPunto(n1)) {    //true
            n2 = ParteFraccionaria(n1);//n2=F1
            n1 = ParteEntera(n1);     //n1=F
            n2 = adecimalFraccionaria(n2, b1);
            n2 = abaseFraccionario(n2.substring(2), b2,60);
        }
        if (ainteger(b1) != ainteger(b2)) {  //true
            if (ainteger(b1) != 10)       //true
                n1 = adecimal(n1, b1);
            n1 = abase(n1, b2);
        }
        if (!n1.equals("") & (VerifPunto(n2)))
            n2 = n2.substring(1);
        return n1 + n2;
    }
    String DoblePrecisionExp(String n1) {
        int k = 0;
        String n2=ParteFraccionaria(n1);
        String n3=ParteEntera(n1);
        k=(!n3.equals("0"))?n3.length()-1:-1*(posicionOne(n2)+1);
        n1 = astringlog((potencia(2, 11 - 1) + k) - 1);
        n1 = conversion(n1, "10", "2");
        while (n1.length() < 11) {
            n1 = "0" + n1;
        }
        return n1;
    }

    String DoblePrecisionMan(String n1) {
        int k = 0;
        String n2 = ParteFraccionaria(n1);   //
        String n3 = ParteEntera(n1);        //1
        String nr=n3+n2;                    //nr=1
        k=(posicionOne(n2)==0)?posicionOne(n2):posicionOne(n2)+1;
        if (VerifPunto(n1) & k == 0)
            k++;                                          //k = 1
        if (nr.length()>1 )
            nr=(!n3.equals("0"))?nr.substring(posicionOne(nr)+1):nr.substring(k+1);   //nr = 110
        else
            nr="";
        while (nr.length() < 52) {
            nr = nr+'0';
        }
        return nr;
    }
    String PrecisionHexa(String n1, String n2, String n3) {
       if (n1!="0")
        n2=conversion(n1+n2+n3,"2","16");
        else
            n2=conversion(n2+n3,"2","16");
        return n2;
    }
    String PrecisionDobleHexa(String n1, String n2, String n3) {
        if (n1!="0")
            n2=n1+n2+n3;
        else
            n2=n2+n3;
        if (n2.length()==64 )
            n2=conversion(n2.substring(0,32),"2", "16") +conversion(n2.substring(32,64),"2","16");
        else
            n2=conversion(n2.substring(0,31),"2","16"  )+conversion(n2.substring(31,63),"2","16"  );
        return n2;
    }
}


