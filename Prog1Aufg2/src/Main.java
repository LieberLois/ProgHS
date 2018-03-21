public class Main {

    public static void main(String[] args) {



        System.out.println("Ausgabe der dezimalen Zahlen als HEX Schreibweise");


        System.out.println("Dezimal: 47 HEX: 2F Unicode: \u002F");
        System.out.println("Dezimal 48 HEX: 30 Unicode: \u0030");
        System.out.println("Dezimal: 49 HEX: 31 Unicode: \u0031");

        System.out.println();

        System.out.println("Dezimal: 64 HEX: 40 Unicode: \u0040");
        System.out.println("Dezimal: 65 HEX: 41 Unicode: \u0041");
        System.out.println("Dezimal: 66 HEX: 42 Unicode: \u0042");

        System.out.println();

        System.out.println("Dezimal: 121 HEX: 79 Unicode: \u0079");
        System.out.println("Dezimal: 122 HEX: 7A Unicode: \u007A");
        System.out.println("Dezimal: 122 HEX: 7B Unicode: \u007B");

        System.out.println();

        System.out.println("Hello World in HEX-Code: \u0048\u0065\u006C\u006C\u006F \u0057\u006F\u0072\u006C\u0064");

        System.out.println();
        System.out.println("Beispiel Rechnung");

        System.out.println("4 + 3 = " + (4 + 3));                 // ganze Zahlen
        System.out.println("4.5e1 + 3.8  = " + (4.5e1 + 3.8 ));   // reelle Zahlen
        // nun weiter mit anderen Zahlen und den Operatoren +, -, *, /

        System.out.println();
        System.out.println();

        System.out.println("7 / 2 = " + 7/2 + "    => Nachkommastelle wird fallengelassen" );
        System.out.println("2.222222222222222222222 * 4.4444444444444444444444 = " + 2.222222222222222222222 * 4.4444444444444444444444);
        System.out.println("99e9 * 88e8 = " + 99e9*88e8);
        System.out.println("5/0 = Numeric Overflow");
        System.out.println("0/0 = Nicht definiert");
;

        System.out.println((int)'A');



    }
}
