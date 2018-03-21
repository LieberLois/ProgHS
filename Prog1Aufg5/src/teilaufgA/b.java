package teilaufgA;

public class b {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

    /*
    +++++++++
     +++++++
      +++++
       +++
        +

        Blanks	 	0	2	4	6	8
        indentWidth	0	1	2	3	4
        fillWidth	9	7	5	3	1
     */

        String indentChar = " ";
        int indentWidth = 0;


        String fillChar = "+";
        int triangleBaseLength = 13;
        int fillWidth = triangleBaseLength;



        while (fillWidth > 0) {
            if(indentWidth >= 0){
                for(int i = indentWidth; i>0; i--){
                    System.out.print(indentChar);
                }
            }



                for(int i = 0; i<fillWidth; i++) {

                        System.out.print(fillChar);

                }


            if(indentWidth >= 0){


                    for(int i = indentWidth; i>0; i--){
                        System.out.print(indentChar);
                    }


                System.out.println();

            }

            fillWidth = fillWidth - 2;
            indentWidth++;
        }

        //fillWidth += 2;
        //indentWidth--;

        while (fillWidth < triangleBaseLength) {
            fillWidth = fillWidth + 2;
            indentWidth--;

            if(indentWidth >= 0){
                for(int i = indentWidth; i>0; i--){
                    System.out.print(indentChar);
                }
            }

            for(int i = 0; i<fillWidth; i++){

                System.out.print(fillChar);


            }

            if(indentWidth >= 0){
                for(int i = indentWidth; i>0; i--){
                    System.out.print(indentChar);


                }
                System.out.println();

            }



        }
    }
}

