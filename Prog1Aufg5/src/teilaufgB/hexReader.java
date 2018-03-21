package teilaufgB;

import java.io.IOException;

public class hexReader {
    public static void main(String[] args) {

        int ergebnis = 0;

        for(int i = 4; i>0; i--){
            try{
                char a = (char)System.in.read();
                if(a == 10){
                    System.out.println("Falsche Eingabe!");
                    break;
                }
                    if("1234567890ABCDEFabcdef".indexOf(a) >= 0){

                        if(Character.isLetter(a)){
                            a = Character.toUpperCase(a);
                        }
                        int produkt2 = (int)Math.pow(16, i-1);
                        int zahl = Integer.valueOf(String.valueOf(a), 16);
                        ergebnis = ergebnis + (zahl*produkt2);

                } else {

                    break;
                }
            }catch(java.io.IOException e){
                e.printStackTrace();
            }
        }
        try {
            if(System.in.read() == 10){
                System.out.println("Dezimal: " + ergebnis);
                System.out.println("Zeichen: " + (char)ergebnis);
            } else {
                System.out.println("Falsche Eingabe!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
