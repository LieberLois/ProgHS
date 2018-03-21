package teilaufgA;

public class cd {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        String fillChar = "+";
        int triangleBaseLength = 13;
        String indentChar = " ";

        int horRepeats = 5;
        int vertRepeats = 5;
        int fillWidth = triangleBaseLength;
        // Erste Zeile

        for(int a = horRepeats; a>0; a--){
            for(int i = 0; i<fillWidth; i++){
                System.out.print(fillChar);
            }
        }
        System.out.println();

        while (vertRepeats!= 0) {
            int indentWidth = 0;
            int direction = -1; // -1 => geht nach unten, 1 => geht nach oben



            fillWidth = triangleBaseLength;

            fillWidth = fillWidth + (2*direction);
            indentWidth = indentWidth-(direction);

            do {

                if (indentWidth >= 0) {
                    for (int i = indentWidth; i > 0; i--) {
                        System.out.print(indentChar);
                    }
                }


                // horRepeat
                int u = horRepeats;
                while (u!=0) {
                    for (int i = 0; i < fillWidth; i++) {
                        // if ((i == 0) || fillWidth == triangleBaseLength) {
                        System.out.print(fillChar);
                        //}

                    }


                    if (indentWidth >= 0) {


                        for (int i = indentWidth; i > 0; i--) {
                            System.out.print(indentChar);
                            System.out.print(indentChar);
                        }
                    }
                    u--;
                }


                fillWidth = fillWidth + (2*direction);
                indentWidth = indentWidth-(direction);

                if(fillWidth <= 1){
                    direction = 1;
                }


                System.out.println();



            }while (fillWidth < triangleBaseLength+1);
            vertRepeats--;
        }
    }
}

