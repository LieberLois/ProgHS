import java.io.IOException;

public class CharArrayManipulation {

    private static char[] array;

    public static void main(String[] args){

        //Array Init

        System.out.println("Eingabe bis 100 Stellen: ");
        System.out.println("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
        System.out.println();

        char[] puffer = new char[101];
        int counter = 0;
        int aufg = 0;


        for(int i = 0; i<puffer.length; i++){

            try {

                char a = (char)System.in.read();
                if(a != 10) {
                    counter++;
                    puffer[i] = a;
                }else{

                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(puffer[100] != '\0'){
            System.out.println("Eingabe zu lang!");
            return;
        }


        array = new char[counter];

        for(int i = 0; i<array.length; i++){
            array[i] = puffer[i];
        }


        System.out.println();
        System.out.println("Welche Teilaufgabe?");

        try{
            aufg = System.in.read() - 48;
        } catch(java.io.IOException e){
            e.printStackTrace();
        }

        switch(aufg) {
            case 1:

                char letter1 = '\0';
                char letter2 = '\0';
                char space = '\0';
                System.out.println();
                System.out.println("Enter [Letter1] space [Letter2] to replace Letter1 with Letter2: ");
                try {
                    System.in.read();
                    letter1 = (char) System.in.read();
                    space = (char) System.in.read();
                    letter2 = (char) System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // letter1 >= a && letter1 <= z || letter1 >= A && letter1 <= Z
                //if (Character.isLetter(letter1) && space == ' ' && Character.isLetter(letter2)) {
                if ((letter1 >= 'a' && letter1 <= 'z' || letter1 >= 'A' && letter1 <= 'Z') && space == ' ' && (letter2 >= 'a' && letter2 <= 'z' || letter2 >= 'A' && letter2 <= 'Z')) {
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == letter1)
                            array[i] = letter2;

                    }
                    System.out.println();
                    printArray();
                } else {
                    System.out.println("Falsche Eingabe!");
                }
                break;
            case 2:

                int index = 0;
                System.out.println();
                System.out.println("Enter the index of the Letter you want to delete: ");

                try {
                    System.in.read();
                    index = System.in.read() - 48;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (index <= array.length) {
                    for (int i = index; i < array.length; i++) {
                        array[index - 1] = array[index];
                        index++;
                    }
                    array[array.length - 1] = '\0';

                    System.out.println();
                    printArray();
                } else {
                    System.out.println("Falsche Eingabe!");
                }


                break;

            case 3:

                char eingabe = '\0';
                System.out.println();
                System.out.println("Enter the letter you want to delete: ");
                try {
                    System.in.read();
                    eingabe = (char) System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                char[] var = new char[array.length];
                int location = 0;

                for (int i = 0; i < var.length; i++) {
                    var[i] = '\0';

                }

                for (int i = 0; i < array.length; i++) {

                    if (eingabe != array[i]) {
                        var[location] = array[i];
                        location++;
                    }

                }
                array = var;

                printArray();

                break;
            case 4:

                int where = 0;
                System.out.println();
                System.out.println("Enter the index of the Letter you want to replace with '-': ");

                try {
                    System.in.read();
                    where = System.in.read() - 48;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                array[where - 1] = '-';

                System.out.println();
                printArray();


                break;

            case 5:
                System.out.println("Search in Array: ");
                int count = 0;

                try{
                    System.in.read();

                    for(int i = 0; i<puffer.length; i++) {
                        puffer[i] = (char) System.in.read();


                        if(puffer[i] != 10){
                            count++;
                        } else
                            break;
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }

                char[] search = new char[count];

                for(int i = 0; i<search.length; i++){
                    search[i] = puffer[i];
                }

                // SEARCH for search[i] == array[i]


                int startIndex = 0;

                for(int j = 0; j<(array.length); j++){


                    if(search[startIndex] == array[j]){
                        if(search.length == 1){
                            System.out.println("Match at " + (j+1));
                        } else if(search.length > 1){
                            if (startIndex+1 < search.length) {
                                startIndex++;
                            } else {
                                System.out.println("Found at Index " + (j-startIndex+1));
                            }
                        }
                    }

                }

                break;

        }

    }


    public static void printArray(){
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i]);

        }
    }


}
