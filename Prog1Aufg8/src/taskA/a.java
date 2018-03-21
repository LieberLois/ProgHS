package taskA;

public class a {
    public static void bisection(double coordX1, double coordX2) {
        final double epsilon = 0.00000001;
        double x1, x2, middle, y_x1, y_middle;

        x1 = coordX1; x2 = coordX2;
        int counter = 0;

        if (x1 < x2) {
            while((x2-x1) > epsilon){
                counter += 1;
                middle = (x1+x2) / 2;
                y_x1 = function.getY(x1);
                y_middle = function.getY(middle);


                if((y_middle > 0 && y_x1 < 0) || (y_middle < 0 &&  y_x1 > 0)){
                    x2 = middle;
                } else {
                    x1 = middle;
                }

                System.out.println("Current Interval: [" + x1 + " ... " + x2 + "]");
            }
             double sol = (x1+x2)/2;
            System.out.println("------------------------------------------------------");
            System.out.println("Solution: " + Math.round(sol*100)/100);
            System.out.println("This operation cycled through " + counter + " loops.");
        } else{
            System.out.println("x1 must be smaller than x2!");
        }

    }
}
