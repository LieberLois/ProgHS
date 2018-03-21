import java.io.IOException;


public class Main {

    static int[] eingabe = new int[7];


    public static void main(String[] args)  {


        System.out.println("Enter a Hex-String: ");


        // Eingabe ins Array
        for(int i = 0; i<eingabe.length; i++){

            int var = 0;


            try {
                var = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (var != 10) {
                if(i>=2 && i<=5){
                    var = toDezi(var);
                }
                eingabe[i] = var;

            } else {
                eingabe[i] = 10;
                break;
            }


        }





        // Eingabe - Kontrolle

        if(eingabe[6] == 10 && eingabe[0] == 92 && eingabe[1] == 117 && numCheck() == 4){


            int e0 = eingabe[5];
            int e1 = eingabe[4];
            int e2 = eingabe[3];
            int e3 = eingabe[2];

            int dezi = e3*(16*16*16) + e2*(16*16)+ e1*(16) + (e0*1);

            System.out.println("Dezimal: " + dezi);
            System.out.println("Unicode: " + (char)dezi);


        } else {

            printError();
        }





    }

    public static void printError(){
        System.out.println("Formatierung einhalten: \\uxxxx");
    }

    public static int numCheck(){
        int count = 0;
        for(int i = 2; i<6;i++) {
            if (eingabe[i] >= 0 && eingabe[i] <=15){

                    count++;


            }
        }

        return count++;
    }


    public static int toDezi(int a){
        switch(a){
            case 65: return 10;
            case 66: return 11;
            case 67: return 12;
            case 68: return 13;
            case 69: return 14;
            case 70: return 15;
            case 48: return 0;
            case 49: return 1;
            case 50: return 2;
            case 51: return 3;
            case 52: return 4;
            case 53: return 5;
            case 54: return 6;
            case 55: return 7;
            case 56: return 8;
            case 57: return 9;

            default: return 0;

        }
    }

}







