public class NeMainZumTesten {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("A:" + (i=5) + " " + i);


        char c = 'D';
        System.out.println("B:" + ( 'a' < c && c < 'z') + " " + c) ;

        c = 'y';
        System.out.println("C:" + (c++) + " " + c) ;

        i = 7;
        System.out.println("D:" + (i /= 3) + " " + i);

        i = 7;
        System.out.println("E:" + (i >> 2) + " " + i);

        i = -1;
        System.out.println("F:" + Integer.toHexString(i));

        System.out.println("G:" + ("2" + "3"));

        Object object = "Hallo";
        System.out.println("H:" + (object instanceof String));

        System.out.println();
        main2();
    }

    public static void main2() {
        int i = 0;
        System.out.println("A:" + i++ + " " + i);

        i = 0;
        System.out.println("B:" + --i + " " + i++ + " " + i);

        char c = 'b';
        System.out.println("C:" + ('d' - c));

        i = 6;
        System.out.println("D:" + (i >> 2) + " " + i);

        i = 0x6;
        System.out.println("E:" + (i & 0x2));
        System.out.println("F:" + (i | 0x2));

        float f = Float.MAX_VALUE;
        System.out.println("G:" + (f+f));

        String s1= new String("hallo"); String s2 = new String("hallo");
        System.out.println("H:" + (s1 == s2) + " " + s1.equals(s2));

    }
}


