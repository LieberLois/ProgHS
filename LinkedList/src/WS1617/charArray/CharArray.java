package WS1617.charArray.charArray;

public class CharArray {
    public static int indexOf(char[] array, char find){
        for(int i = 0; i<array.length;i++){
            if(array[i] == find){
                return i;
            }
        }
        return -1;
    }

    public static char[] deleteAt(char[] array, int loc){
        char[] newArray = new char[array.length-1];

        for(int i = loc; i < array.length-1; i++){
            array[i] = array[i+1];
        }

        for(int i = 0; i<newArray.length; i++){
            newArray[i] = array[i];
        }

        return newArray;
    }

    public static char[] deleteAll(char[] array, char del){
        while(indexOf(array, del) != -1){
            array = deleteAt(array, indexOf(array, del));
        }
        return array;
    }

    public static void printArray(char[] array){
        for(Character c : array){
            System.out.print(c);
        }
        System.out.println();
    }

}
