package com.example.baseconverter;

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
        long n = Long.parseLong(n1);
        long b = Long.parseLong(b1);
        if (n==0)
            resultado ="0";
        while (n > 0) {
            //  String truco=n%b+""; otro metodo a string
            String truco = String.valueOf(n % b);
            int dig = ainteger(truco);
            n = n / b;
            resultado = a.charAt(dig) + resultado;
        }
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
            nu = nu + val;
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
    byte EncontrarPunto(String n1) {
        byte k = 0;
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
    boolean VerifLetter(String n1) {
        boolean b = false;
        int i = 0;
        while(i<=n1.length()||!b) {
            if (n1.charAt(i) == 'A' || n1.charAt(i) == 'B' || n1.charAt(i) == 'C' || n1.charAt(i) == 'D'
                    || n1.charAt(i) == 'E' || n1.charAt(i) == 'F') {
                b = true;
            }
            i++;
        }
     return b;
    }
    String ParteEntera(String n1) {
        return n1.substring(0, EncontrarPunto(n1));
    }

    String ParteFraccionaria(String n1) {
        return n1.substring(EncontrarPunto(n1) + 1);
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

    //Convertir decimal fraccionario a otra base       //5.125    b=2
    String abaseFraccionario(String n1, String b1) {
        n1 = "0." + n1;
        String nt = "0.";
        double nf = adouble(n1);    //0.125
        int k = 12;
        boolean b = true;
        if (ainteger(b1) != 10) {
            while ((k > 0) & b) {  //12 bit de decimales
                nf = nf * ainteger(b1);                        //0.125*2=0.25
                String pe = ParteEntera(astringdouble(nf));   //pe=0
                nt = nt + codificar(pe);
                String pf = ParteFraccionaria(astringdouble(nf));   //nf=25
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
            n2 = abaseFraccionario(n2.substring(2), b2);
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
    String suma(String n1, String n2, String b) {
        String n11 = adecimal(n1, b);
        String n22 = adecimal(n2, b);
        long r = along(n11) + along(n22);
        String res = abase(astringlog(r), b);
        return res;
    }

    String resta(String n1, String n2, String b) {
        String n11 = adecimal(n1, b);
        String n22 = adecimal(n2, b);
        Long r = along(n11) - along(n22);
        String res = abase(astringlog(r), b);
        return res;
    }

    String multiplicacion(String n1, String n2, String b) {
        String n11 = adecimal(n1, b);
        String n22 = adecimal(n2, b);
        Long r = along(n11) * along(n22);
        String res = abase(astringlog(r), b);
        return res;
    }

    String division(String n1, String n2, String b) {
        String n11 = adecimal(n1, b);
        String n22 = adecimal(n2, b);
        Long r = along(n11) / along(n22);
        String res = abase(astringlog(r), b);
        return res;
    }

    String SimplePrecisionMan(String n1) {
        int k=0;
        if (adouble(n1)>1) {
            n1 = ParteEntera(n1) + ParteFraccionaria(n1);
            n1 = n1.substring(1);
            while (n1.length() < 23) {
                n1 = n1 + "0";
            }
        }else{
            while (n1.charAt(k)!='1') {
                k++;
        }
            n1=n1.substring(k+1);
            while (n1.length() < 23) {
                n1 = n1 + "0";
            }
        }
        return n1;
    }

    //10001.010
    String SimplePrecisionExp(String n1) {
        int k = 0;
        String n2 = ParteEntera(n1);
        Double n3 = adouble(n1);
        if (!n2.equals("0"))
            k = n2.length() - 1;
        else{while(n3 < 1 ) {
            n3 = n3 * 10;
            k--;
        }
        }
        n1 = astringlog((potencia(2, 8 - 1) + k) - 1);
        n1 = conversion(n1, "10", "2");
        while (n1.length()<8){
            n1="0"+n1;
        }
        return n1;
    }

    String DoblePrecisionExp(String n1) {
        int k = 0;
        String n2 = ParteEntera(n1);
        Double n3 = adouble(n1);
        if (!n2.equals("0"))
            k = n2.length() - 1;
        else{while(n3 < 1 ) {
            n3 = n3 * 10;
            k--;
        }
        }
        n1 = astringlog((potencia(2, 11 - 1) + k) - 1);
        n1 = conversion(n1, "10", "2");
        while (n1.length()<11){
            n1="0"+n1;
        }
        return n1;
    }

    String DoblePrecisionMan(String n1) {
        int k=0;
        if (adouble(n1)>1) {
        n1 = ParteEntera(n1) + ParteFraccionaria(n1);
        n1 = n1.substring(1);
        while (n1.length() < 52) {
            n1 = n1 + "0";
        }
            }else{
                while (n1.charAt(k)!='1') {
                    k++;
                }
                n1=n1.substring(k+1);
                while (n1.length() < 52) {
                    n1 = n1 + "0";
                }
        }
        return n1;
    }
    String PrecisionSimpleHexa(String n1, String n2, String n3) {
       // String parte1 = n1 + n2 + n3.substring(0,6);
        //String parte2= n3.substring(7);
        //n2 = conversion(parte1, "2", "16")+conversion(parte2,"2","16");
        n1=n1+n2+n3;
        n2=conversion(n1,"2","16");
        /*while (n1.length()>0) {
            n3 = n1.substring(0, 4);
            if (n3.equals("0000"))
                n2 = n2 + "0";
            else
                n2 = n2 + conversion(n3,"2","16");
            n1 = n1.substring(4,n1.length());
        }*/
        return n2;
    }
    String PrecisionDobleHexa(String n1, String n2, String n3) {
        String parte1 = n1 + n2 + n3.substring(0, 20);
        String parte2 = n3.substring(21);
        n2 = conversion(parte1, "2", "16") + conversion(parte2, "2", "16");
        while (n2.length()<16){
            n2=n2+"0";
        }
        /*while (n1.length()>0) {
            n3 = n1.substring(0, 4);
            if (n3.equals("0000"))
                n2 = n2 + "0";
            else
                n2 = n2 + conversion(n3,"2","16");
            n1 = n1.substring(4,n1.length());
        }*/
        return n2;
    }
}


