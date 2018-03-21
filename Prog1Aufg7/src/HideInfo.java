public class HideInfo {

    public static char[] swapEIandAU(char[] currentArray){

        currentArray = CharArrayManipulation.replaceLetter(currentArray, 'e', 'i');
        currentArray = CharArrayManipulation.replaceLetter(currentArray, 'a', 'u');

        return currentArray;
    }

    public static char[] addEeverySecondKey(char[] currentArray){
        char[] e = {'e'};
        for(int i = 0; i < currentArray.length; i++){
            if((i+1)%2 == 0){
                currentArray = CharArrayManipulation.addCharacters(currentArray, e, i+1);
            }
        }

        return currentArray;
    }

    public static char[] mixSecretInText(char[] currentArray){

        char[] e = {'s','e','c','r','e','t'};
        char[] current = new char[1];
        int index = 0;


        for(int i = 0; i < currentArray.length; i++){
            if((i+1)%2 == 0){
                if(index==e.length){
                    index=0;
                }
                current[0] = e[index];
                currentArray = CharArrayManipulation.addCharacters(currentArray, current , i+1);
                index++;
            }
        }

        return currentArray;
    }

    public static char[] removeAEIOU(char[] currentArray){

        char[] e = {'a','e','i','o','u'};
        char[] remove = new char[1];

        int index = -1;

        for (int i = 0; i < 5; i++) {
            remove[0] = e[i];
            index  = CharArrayManipulation.search(currentArray, remove);
            if (index > -1) {
                currentArray = CharArrayManipulation.removeIndex(currentArray, index);
            }
        }

        return currentArray;
    }


}
