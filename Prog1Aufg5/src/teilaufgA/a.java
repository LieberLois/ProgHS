package teilaufgA;

public class a {

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
        triangleBaseLength	9	7	5	3	1
     */

        String indentChar = " ";
        int indentWidth = 0;

        String fillChar = "+";
        int triangleBaseLength = 8;
        int triangleHeight = 0;


        while (triangleBaseLength > 0) {
            if(indentWidth >= 0){
                for(int i = indentWidth; i>0; i--){
                    System.out.print(indentChar);
                }
            }

            for(int i = 0; i<triangleBaseLength; i++){

                System.out.print(fillChar);


            }

            if(indentWidth >= 0){
                for(int i = indentWidth; i>0; i--){
                    System.out.print(indentChar);


                }
                System.out.println();
                triangleHeight++;
            }

            triangleBaseLength = triangleBaseLength - 2;
            indentWidth++;
        }

        System.out.println();
        System.out.println();

        System.out.println("Triangle Height is " + triangleHeight);

    }
}

