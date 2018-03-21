@SuppressWarnings("Duplicates")
public class Crypto {

    public static char[] encryptTableCaesar(char[] currentArray, int amount){
        char[] lowercase = new char[26];
        for(int i = 0; i< 26; i++){
                lowercase[i] = (char)('a' + i);
        }

        for(int j = 0; j < currentArray.length; j++){
            int index = -1;
            for(int i = 0; i < lowercase.length; i++){
                if(currentArray[j] == lowercase[i]){
                    index = i;
                    break;
                }
            }

            if(index+amount > 25){
                index = index + amount -26;
            } else {
                index += amount;
            }
            currentArray[j] = lowercase[index];
        }



        return currentArray;
    }

    public static char[] decryptTableCaesar(char[] currentArray, int amount){
        return encryptTableCaesar(currentArray, -amount);
    }

    public static char[] encryptRandom(char[] currentArray){

        //0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25
        //a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z
        //q   a   y   w   s   x   e   d   c   r   f   v   t   g   b   z   h   n   u   j   m   i   k   o   l   p

        char[] lowercase = new char[26];
        //               a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z
        char[] crypt = {'q','a','y','w','s','x','e','d','c','r','f','v','t','g','b','z','h','n','u','j','m','i','k','o','l','p'};

        for(int i = 0; i< 26; i++){
            lowercase[i] = (char)('a' + i);
        }

        for(int i = 0; i < currentArray.length; i++){
            /*for(int j = 0; j < 26; j++){
                if(currentArray[i] == lowercase[j]){
                    currentArray[i] = crypt[j];
                    break;
                }
            }
            */
            int index = currentArray[i] - 'a';
            currentArray[i] = crypt[index];
        }



        return currentArray;
    }

    public static char[] decryptRandom(char[] currentArray){
        char[] lowercase = new char[26];
        char[] crypt = {'q','a','y','w','s','x','e','d','c','r','f','v','t','g','b','z','h','n','u','j','m','i','k','o','l','p'};

        for(int i = 0; i< 26; i++){
            lowercase[i] = (char)('a' + i);
        }

        for(int i = 0; i < currentArray.length; i++){
            for(int j = 0; j < 26; j++){
                if(currentArray[i] == crypt[j]){
                    currentArray[i] = lowercase[j];
                    break;
                }
            }
        }



        return currentArray;
    }

}
