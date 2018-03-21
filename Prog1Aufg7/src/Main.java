public class Main {

    public static void main(String[] args) throws Exception{
        char[] manipulationArray;

        char whichMethod = '\0';
        char[] puffer = new char[101];

        System.out.println("Change e to i and a to u    (1)");
        System.out.println("Insert 'e' every second key (2)");
        System.out.println("Mix secret in Text          (3)");
        System.out.println("Remove a, e, i, o, u        (4)");
        System.out.println("Encrypt with Random Chart   (5)");
        System.out.println("Decrypt with Random Chart   (6)");
        System.out.println("Encrypt with Caesar Table   (7)");
        System.out.println("Decrypt with Caesar Table   (8)");
        System.out.println("Q / q to quit.");
        System.out.println();



        whichMethod = (char)System.in.read();
        if (!((whichMethod >= 1 && whichMethod <= '8') || (whichMethod == 'q' || whichMethod == 'Q')) || System.in.read() != 10){
            System.out.println("Wrong input!");
            return;
        }

        System.out.println("Enter a String (max 100 keys): ");

        for(int i = 0; i<puffer.length; i++){

                char a = (char)System.in.read();
                if(a != 10) {
                    puffer[i] = a;
                }else{
                    break;
                }

        }


        if(puffer[100] != '\0'){
            System.out.println("Max 100 keys!");
            return;
        } else {
            manipulationArray = CharArrayManipulation.shortenArray(puffer);
        }


        switch(whichMethod){
            case '1':
                System.out.println();
                CharArrayManipulation.printArray(manipulationArray);
                System.out.print("-> ");
                CharArrayManipulation.printArray(HideInfo.swapEIandAU(manipulationArray));
                break;

            case '2':
                System.out.println();
                CharArrayManipulation.printArray(manipulationArray);
                System.out.print("-> ");
                CharArrayManipulation.printArray(HideInfo.addEeverySecondKey(manipulationArray));
                break;
            case '3':
                System.out.println();
                CharArrayManipulation.printArray(manipulationArray);
                System.out.print("-> ");
                CharArrayManipulation.printArray(HideInfo.mixSecretInText(manipulationArray));
                break;
            case '4':
                System.out.println();
                CharArrayManipulation.printArray(manipulationArray);
                System.out.print("-> ");
                CharArrayManipulation.printArray(HideInfo.removeAEIOU(manipulationArray));
                break;
            case 'q':
                System.out.println("Program ended.");
                break;
            case 'Q':
                System.out.println("Program ended.");
                break;
            case '5':
                manipulationArray = Crypto.encryptRandom(manipulationArray);
                CharArrayManipulation.printArray(manipulationArray);
                break;
            case '6':
                manipulationArray = Crypto.decryptRandom(manipulationArray);
                CharArrayManipulation.printArray(manipulationArray);
                break;

            case '7':
                int key;

                // abcdefghijklmnopqrstuvwxyz efghijklmnopqrstuvwxyzabcd
                //      ^--------------------------^


                System.out.println("Enter your key: ");
                key = 0;

                while(true){
                    int test = System.in.read();
                    if(test == 10){
                        break;
                    }
                    key = key*10 + (test - '0');

                }

                manipulationArray = Crypto.encryptTableCaesar(manipulationArray, key);
                CharArrayManipulation.printArray(manipulationArray);
                break;
            case '8':
                // efghijklmnopqrstuvwxyzabcd abcdefghijklmnopqrstuvwxyz
                //      ^--------------------------^
                System.out.println("Enter your key: ");
                key = 0;

                while(true){
                    int test = System.in.read();
                    if(test == 10){
                        break;
                    }
                    key = key*10 + (test - '0');

                }
                manipulationArray = Crypto.decryptTableCaesar(manipulationArray, key);
                CharArrayManipulation.printArray(manipulationArray);
                break;
            default:
                System.out.println("Wrong input.");
        }

    }
}
