package teilaufgC;

public class LiteralReader{

    public static void main(String[] args) throws Exception {
        final int STATE_INITIAL = 0;
        final int STATE_SIGN = 1;
        final int STATE_DEC = 2;
        final int STATE_WRONG = 3;
        final int STATE_COMPL = 4;
        final int STATE_CLEAR = 5;
        final int STATE_HEX = 6;
        final int STATE_X = 7;

        int currentState = STATE_INITIAL;
        int column = 0;
        int sign = 1;
        int value = 0;
        int hexCount = -1;

        System.out.println("enter decimal literal, hex code in format 0xXXXXXXXX or q/Q to quit");

        while (true) {
            char c = (char) System.in.read();
            column++;


            // check input and make state transitions triggered by input
            switch (currentState) {
                case (STATE_INITIAL):
                    // reset values
                    value = 0;
                    sign = 1;
                    column = 1;
                    hexCount = -1;


                    if ((c == 'q') || (c == 'Q')) {

                        // Beendet die laufende Methode (return)

                        System.out.println("bye");
                        return;
                    } else if ('1' <= c && c <= '9')
                        currentState = STATE_DEC;
                        // Nach einer dezimalen folgt noch eine dezimale
                    else if (c == '0') {
                        currentState = STATE_X;

                     }else if ((c == '+') || (c == '-'))
                        currentState = STATE_SIGN;
                    else if ((c == '\r') || (c == '\n'))
                        ; // Bei KEINER Eingabe wartet das Programm auf eine neue Eingabe
                    else
                        currentState = STATE_WRONG;
                    // Alle anderen Eingaben sind FEHLERHAFT
                    break;

                case (STATE_SIGN):
                    if ('0' <= c && c <= '9')
                        currentState = STATE_DEC;
                        // Nach einem + oder - kommt eine Zahl, sonst FALSCH
                    else
                        currentState = STATE_WRONG;
                    break;


                case(STATE_X):
                    if (c == 'x') {
                        currentState = STATE_HEX;

                        continue;

                    } else {
                        currentState = STATE_WRONG;
                    }
                    break;

                case(STATE_HEX):
                    hexCount++;
                    if (('0' <= c && c <= '9') || (c >= 'a' && c <= 'f') || (c>= 'A' && c <= 'F')) {

                       if(hexCount > 8){
                            currentState = STATE_WRONG;
                       }

                    }else if ((c == '\r') || (c == '\n')){
                        if (hexCount >0){
                            currentState = STATE_COMPL;
                        }else{
                            currentState = STATE_WRONG;
                        }
                    } else {
                        currentState = STATE_WRONG;
                    }
                    break;



                case (STATE_DEC):
                    if ('0' <= c && c <= '9') { // nothing to do
                    } else if ((c == '\r') || (c == '\n'))
                        // Linefeed beendet die Eingabe
                        currentState = STATE_COMPL;
                    else
                        // Alles außer Dezimalen oder Linefeed nach anderer Dezimalen/Zeichen ist falsch
                        currentState = STATE_WRONG;
                    break;


                case (STATE_CLEAR):
                    if ((c == '\r') || (c == '\n'))
                        // Zurück zum Start, RESET

                        currentState = STATE_INITIAL;
                    break;

                default:
                    System.out.println("Unknown State: " + currentState);
            }

            if (currentState == STATE_WRONG) {
                System.out.println("Fehlerhafte Eingabe an Position : " + column);
                if ((c == '\r') || (c == '\n'))
                    currentState = STATE_INITIAL;
                else
                    currentState = STATE_CLEAR;
                continue;
            }

            if (currentState == STATE_COMPL) {
                System.out.println("ermittelter int-Wert: " + value);
                currentState = STATE_INITIAL;
                continue;
            }

            // now interpret unicode character
            int cipherValue = 0;
            if ('0' <= c && c <= '9')
                cipherValue = c - '0';      // ASCII-Code von 0 ist 48 => cipherValue = 48 - 48 => 0
            else if (c == '-')
                sign = -1;  // Vorzeichen setzen!!
            else if(c >= 'a' && c <= 'f')
                cipherValue = Integer.valueOf(String.valueOf(c), 16);

            // apply Horner
            switch (currentState) {
                case (STATE_DEC):
                    // Kontrollfrage: Warum die Fallunterscheidung fuer neg. bzw. pos. Vorzeichen
                    // und nicht einfach zum Schluss sign * errechneter Betrag ?

                    // Weil ins negative eine Zahl weiter gezählt werden kann als ins positive
                    if (sign > 0)
                        if ((Integer.MAX_VALUE - cipherValue)/10 >= value ) {
                            value = value * 10 + cipherValue;

                        }else {
                            System.out.println("Zahl zu gross");
                            currentState = STATE_CLEAR;
                        }

                    if (sign < 0)
                        if ((Integer.MIN_VALUE + cipherValue)/10 <= value )
                            value = value * 10 - cipherValue;
                        else {
                            System.out.println("Zahl zu klein");
                            currentState = STATE_CLEAR;
                        }


                    break;

                case(STATE_HEX):


                    /*
                    Ohne Horner-Schema
                    if ((Integer.MAX_VALUE - cipherValue)/16 >= value ) {

                        int produkt = (int)Math.pow(16, (8-column+2));
                        int zahl = Integer.valueOf(String.valueOf(c), 16);
                        value = value + (zahl*produkt);

                    }else {
                        System.out.println("Zahl zu gross");
                        currentState = STATE_CLEAR;
                    }

                    break;

                    */


                        if ((Integer.MAX_VALUE - cipherValue)/16 >= value ) {
                            value = value * 16 + cipherValue;

                        }else {
                            System.out.println("Zahl zu gross");
                            currentState = STATE_CLEAR;
                        }


                    break;

            }
        }
    }
}