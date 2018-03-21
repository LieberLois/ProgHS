package WS1617.charArray.charArray;




public class TestKlasse {
    static char[] array = {'a','b','c','a','c'};

    public static void main(String[] args) {
        CharArray.printArray(array);
        array = CharArray.deleteAll(array, 'a');
        CharArray.printArray(array);
    }
}
