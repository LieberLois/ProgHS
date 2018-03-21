public class CharArrayManipulation {

    /*

    private static char[] array;
    public static void main(String[] args) {

        while (true) {
            System.out.println("Choose an Action: ");
            System.out.println("Set Array (1), " +
                    "Print Array (2), " +
                    "Replace Letter (3), " +
                    "Search in Array (4), \n" +
                    "Remove Index (5), " +
                    "Remove Char (6), " +
                    "Insert Char/s (7), " +
                    "or q/Q to quit.");

            int action = -1;

            try{
                action = (char)System.in.read();
                if(System.in.read() != 10) {
                    System.out.println("Falsche Eingabe! \n");
                    while(System.in.read() != 10){
                        System.in.read();
                    }
                    continue;
                }
            } catch (java.io.IOException e){
                e.printStackTrace();
            }

            switch (action){
                case '1':
                    char[] puffer = new char[101];

                    System.out.println("Enter a String (max 100 keys): ");

                    for(int i = 0; i<puffer.length; i++){

                        try {

                            char a = (char)System.in.read();
                            if(a != 10) {
                                puffer[i] = a;
                            }else{

                                break;
                            }

                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }

                    }

                    if(puffer[100] != '\0'){
                        System.out.println("Max 100 keys!");
                    } else {
                        array = shortenArray(puffer);
                    }

                    break;
                case '2':
                    printArray(array);
                    break;
                case '3':


                        char letter1 = '\0';
                        char letter2 = '\0';
                        char space = '\0';
                        System.out.println();
                        System.out.println("Enter [Letter1] space [Letter2] to replace Letter1 with Letter2: ");
                        try {
                            letter1 = (char) System.in.read();
                            space = (char) System.in.read();
                            letter2 = (char) System.in.read();
                            System.in.read();


                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }

                        if ((letter1 >= 'a' && letter1 <= 'z' || letter1 >= 'A' && letter1 <= 'Z') && space == ' ' && (letter2 >= 'a' && letter2 <= 'z' || letter2 >= 'A' && letter2 <= 'Z')) {
                            array = replaceLetter(array, letter1, letter2);
                        } else {
                            System.out.println("Wrong input! \n");
                        }



                    break;
                case '4':

                        System.out.println("Enter a search String (max 10 keys): ");
                        puffer = new char[10];
                        int counter = 0;

                        try {
                            for (int i = 0; i < puffer.length; i++) {
                                puffer[i] = (char) System.in.read();

                                if (puffer[i] != 10) {
                                    counter++;
                                } else
                                    break;
                            }
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }

                        char[] search = new char[counter];


                        for (int i = 0; i < search.length; i++) {
                            search[i] = puffer[i];
                        }

                        int s = search(array, search);
                        if (s >= -1) {
                            System.out.println("Found at Index: " + s + "\n");
                        }


                    break;

                case '5':



                        int index = 0 - '0';
                        System.out.println();
                        System.out.println("Enter the Index of the key you want to remove: ");

                        try {
                            index += (char)System.in.read();
                            System.in.read();


                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }

                        array = removeIndex(array, index);



                    break;

                case '6':
                    char eingabe = '\0';
                    System.out.println();
                    System.out.println("Enter the letter you want to delete: ");
                    try {
                        //System.in.read();
                        eingabe = (char) System.in.read();
                        System.in.read();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }

                    array = removeCharacter(array, eingabe);
                    break;

                case '7':
                    index = 0 - '0';
                    System.out.println();
                    System.out.println("Enter the Index of the key you want insert the char/s: ");

                    try {
                        index += (char)System.in.read();
                        System.in.read();


                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter the char/s you want to insert (max 10 keys): ");
                    puffer = new char[10];

                    try {
                        for (int i = 0; i < puffer.length; i++) {
                            char c = (char) System.in.read();
                            if (c != 10) {
                                puffer[i] = c;
                            } else {
                                break;
                            }
                        }

                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }

                    array = addCharacters(array, shortenArray(puffer), index);

                    break;
                case 'q':
                    return;
                case 'Q':
                    return;
                case 'a':
                    array = HideInfo.swapEIandAU(array);
                    break;
                case 'b':
                    array = HideInfo.addEeverySecondKey(array);
                    break;
                case 'c':
                    array = HideInfo.mixSecretInText(array);
                    break;
                case 'd':
                    array = HideInfo.removeAEIOU(array);
                    break;

            }
        }

    }

    */

    public static char[] shortenArray(char[] puffer){
        int counter = 0;

        for(int i = 0; i<puffer.length;i++){
            if(puffer[i] != '\0' && puffer[i] != '\n'){
                counter++;
            } else {
                break;
            }
        }

        char[] currentArray = new char[counter];

        for(int i = 0; i<currentArray.length; i++){
           currentArray[i] = puffer[i];
        }

        return currentArray;

    }

    public static void printArray(char[] currentArray){
            currentArray = shortenArray(currentArray);

            System.out.print("Array: ");
            for(int i = 0; i < currentArray.length; i++){
                System.out.print(currentArray[i]);

            }
            System.out.println("\n");

    }

    public static char[] replaceLetter(char[] currentArray, char letter1, char letter2){


        for (int i = 0; i < currentArray.length; i++) {
            if (currentArray[i] == letter1)
                currentArray[i] = letter2;

        }

        return currentArray;
    }

    public static int search(char[] currentArray, char[] search){
        int findIndex = -1;

            boolean find = false;
            int searchIndex = 0;


            if (search.length <= currentArray.length) {
                for(int i = 0; i<currentArray.length; i++){
                    if(search[searchIndex] == currentArray[i]){
                        if(search.length == 1){
                            findIndex = i+1;
                            break;
                        } else {
                            find = true;

                            while (find && (searchIndex+1) < search.length){
                                searchIndex++;
                                if(search[searchIndex] == currentArray[i+searchIndex])
                                    find = true;
                                else {
                                    find = false;
                                    break;
                                }
                            }

                            if(find){
                                findIndex = i+1;
                                break;
                            }

                        }
                    }
                }
            } else {
                System.out.println("Search String longer than Array! \n");
            }


        return findIndex;

    }

    public static char[] removeIndex(char[] currentArray, int index){

        if (index <= currentArray.length) {
            for (int i = index; i < currentArray.length; i++) {
                currentArray[index - 1] = currentArray[index];
                index++;
            }
            currentArray[currentArray.length - 1] = 10;


        }

        return shortenArray(currentArray);
    }

    public static char[] removeCharacter(char[] currentArray, char c){

        char[] var = new char[currentArray.length];
        int location = 0;

        for (int i = 0; i < var.length; i++) {
            var[i] = 10;

        }

        for (int i = 0; i < currentArray.length; i++) {

            if (c != currentArray[i]) {
                var[location] = currentArray[i];
                location++;
            }

        }
        currentArray = var;

        return shortenArray(currentArray);
    }

    public static char[] addCharacters(char[] currentArray, char[] chars, int index){
        char[] tmp = new char[(currentArray.length+chars.length)];
        index = index - 1;
        int counterCurr = 0;
        int counterChar = 0;

        for(int i = 0; i < tmp.length; i++){
            if(i < index){
                tmp[i] = currentArray[counterCurr];
                counterCurr++;
            } else if (i >= index && counterChar <= (chars.length -1)){
                tmp[i] = chars[counterChar];
                counterChar++;
            } else {
                if (counterCurr < currentArray.length) {
                    tmp[i] = currentArray[counterCurr];
                    counterCurr++;
                }
            }
        }

        return tmp;
    }

    public static char getCharAtIndex(char[] currentArray, int index){
        char e = currentArray[index];
        return e;
    }

    public static char[] setCharAtIndex(char[] currentArray, char letter, int index){
        currentArray[index] = letter;
        return currentArray;
    }

    public static int indexOf(char[] currentArray, char letter){

        int index = -1;

        for(int i = 0; i<currentArray.length;i++){
            if(currentArray[i] == letter){
                index = i;
                return index+1;
            }
        }

        return index;

    }
}
