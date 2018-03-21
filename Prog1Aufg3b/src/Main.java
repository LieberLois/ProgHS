import java.io.IOException;

public class Main {

    static boolean active = true;
    static int one = 0;
    static int four = 0;
    static boolean op1 = false;
    static boolean op2 = false;
    static String operator;
    static int amountOperators = 0;


    public static void main(String[] args) {

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        op1 = false;
        op2 = false;
        operator = "";
        amountOperators = 0;


        System.out.println("Enter [T/F] [&,&&, |, ||, ^] [T/F) or exit");


        while (active) {

            one = 0;
            two = 0;
            three = 0;
            four = 0;
            op1 = false;
            op2 = false;
            operator = "";
            amountOperators = 0;



            try {
                one = System.in.read();
                two = System.in.read();
                three = System.in.read();
                four = System.in.read();

                if(four != 10){
                    System.in.read();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }





                if((one == 84 || one == 70) && (four == 10 || four == 84 || four == 70)){
                    op1 = returnBoolean(one);



                    if(four==10){
                        op2 = returnBoolean(three);
                        amountOperators = 1;

                    } else {
                        op2 = returnBoolean(four);
                        amountOperators = 2;

                    }


                    System.out.println();



                } else {
                    System.out.println("Fehler: Eingabe muss nach dem Schema [T/F] [&,&&, |, ||, ^] [T/F) erfolgen.");
                }


                if (amountOperators == 2) {
                    operator = Character.toString((char)two) + Character.toString((char)three);
                    switch(operator){
                        case "&&":
                            operator = "&&";
                            System.out.println(op1 && op2);

                            break;

                        case "||":
                            operator = "||";
                            System.out.println(op1 || op2);

                            break;

                    }

                } else {
                    operator = Character.toString((char)two);
                    switch(operator){

                        case "|":
                            operator = "|";
                            System.out.println(op1 | op2);
                            break;

                        case "^":
                            operator = "^";
                            System.out.println(op1 ^ op2);
                            break;

                        case "&":
                            operator = "&";
                            System.out.println(op1 & op2);
                            break;
                    }

                }

            System.out.println("Enter [T/F] [&,&&, |, ||, ^] [T/F) or exit");




        }


        // System.out.println((char)65);






    }

    public static boolean returnBoolean(int i) {
        if(i == 84){return true;} else {
            return false;
        }

    }
}




