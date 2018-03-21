package taskD;
@SuppressWarnings("Duplicates")
public class prime {
    public static boolean primCheck(int a) {

        boolean b = false;

        if (a == 1) {
            b = false;			// Zahl 1 ist keine Prima
        } else if (a == 2) {
            b = true;			// Zahl 2 ist eine Prima
        } else {


            //Optimierung:


            //for(int i = 2; i < Math.ceil(Math.sqrt(a)); i++){


            for (int i = 2; i < a; i++) {
                // Der Wert der Wurzel wird auf den nächsthöheren int-Wert gesetzt
                // zum Beispiel 2.4 wird zu 3
                if ((a % i) == 0) {
                    b = false;
                    break;
                    // Falls ein Teiler ohne Rest gefunden wird, Schleife stoppen
                } else {
                    b = true;
                }
            }

        }

        return b;
    }

    public static int[] findPrimes(int limit){

        int[] buffer = new int[limit];
        int counter = 0;

        for(int m = 1; m < limit; m++){
            if(primCheck(m)){
                buffer[counter] = m;
                counter++;
            }
        }

        int[] primes = new int[counter];
        for(int i = 0; i < primes.length; i++){
            primes[i] = buffer[i];
        }

        buffer = null;


        return primes;
    }

    public static long[] primeDuration(int limit){

        long time = System.nanoTime();
        long counter = 0;
        long returnValues[] = new long[2];

        for(int m = 1; m < limit; m++){
            if(primCheck(m)){
                counter++;
            }
        }

        time = System.nanoTime() - time;
        returnValues[0] = counter;
        returnValues[1] = time;


        return returnValues;
    }

    public static void timeForFindPrimes(long steps, long stepsize){
        long[] array = new long[2];
        for(long i = stepsize; i <steps+1; i += stepsize){
            array = primeDuration((int)i);
            System.out.println(array[1]);
        }

    }

    public static void timeForFindDoublePrimes(long steps){
        long[] array = new long[2];
        for(long i = 2; i <steps+1; i  = i * 2){
            array = primeDuration((int)i);
            System.out.println(array[1]);
        }

    }

}
