import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        boolean active = true;

        Scanner sc = new Scanner(System.in);



        boolean op1 = false;
        boolean op2 = false;
        active = true;


        System.out.print("Enter AND, OR or XOR: ");
        String eingabe = sc.next();

        while (active) {



            switch (eingabe.toUpperCase()){
                case "AND":

                    // AND
                    System.out.println();
                    System.out.println();




                    System.out.println(" &&   | " + op2 + " | " + !op2);
                    System.out.println("------|-------|------");
                    System.out.println(op1 + " | " + (op1 && op2) + " | " + (op1 && !op2));
                    op1 = !op1;
                    System.out.println(op1 + "  | " + (op1 && op2) + " | " + (op1 && !op2));

                    System.out.println();
                    System.out.println();

                    // AND mit einem &

                    op1 = false;
                    op2 = false;

                    System.out.println(" &    | " + op2 + " | " + !op2);
                    System.out.println("------|-------|------");
                    System.out.println(op1 + " | " + (op1 & op2) + " | " + (op1 & !op2));
                    op1 = !op1;
                    System.out.println(op1 + "  | " + (op1 & op2) + " | " + (op1 & !op2));

                    System.out.println();
                    System.out.println();
                    break;

                case "OR":

                    // OR
                    System.out.println();
                    System.out.println();

                    op1 = false;
                    op2 = false;

                    System.out.println(" ||   | " + op2 + " | " + !op2);
                    System.out.println("------|-------|------");
                    System.out.println(op1 + " | " + (op1 || op2) + " | " + (op1 || !op2));
                    op1 = !op1;
                    System.out.println(op1 + "  | " + (op1 || op2) +"  | " + (op1 || !op2));

                    System.out.println();
                    System.out.println();

                    // OR mit einem |
                    System.out.println();
                    System.out.println();

                    op1 = false;
                    op2 = false;

                    System.out.println(" |    | " + op2 + " | " + !op2);
                    System.out.println("------|-------|------");
                    System.out.println(op1 + " | " + (op1 | op2) + " | " + (op1 | !op2));
                    op1 = !op1;
                    System.out.println(op1 + "  | " + (op1 | op2) +"  | " + (op1 | !op2));

                    System.out.println();
                    System.out.println();
                    break;

                case "XOR":

                    // XOR
                    System.out.println();
                    System.out.println();

                    op1 = false;
                    op2 = false;

                    System.out.println("  ^   | " + op2 + " | " + !op2);
                    System.out.println("------|-------|------");
                    System.out.println(op1 + " | " + (op1 ^ op2) + " | " + (op1 ^ !op2));
                    op1 = !op1;
                    System.out.println(op1 + "  | " + (op1 ^ op2) + "  | " + (op1 ^ !op2));

                    break;




            }


            System.out.println();
            System.out.println();
            System.out.print("Enter AND, OR, XOR or EXIT: ");
            eingabe = sc.next();
            active = eingabe.equalsIgnoreCase("EXIT") ? false :  true;

        }

        active = true;



    }
}
