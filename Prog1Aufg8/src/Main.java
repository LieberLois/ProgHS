import taskA.a;
import taskB.*;
import taskC.pattern;
import taskD.prime;




public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Which task?");
        System.out.println("Get one solution                (1)");
        System.out.println("a^n with loop/recurse           (2)");
        System.out.println("Pattern                         (3)");
        System.out.println("Check Prime                     (4)");
        System.out.println("Print Primes                    (5)");
        System.out.println("Duration Analysis Primes        (6)");
        System.out.println("Prime Analysis (Doubling)       (7)");


        char c = (char)System.in.read();
        if(c > '9' ||c < '0'){
            System.out.println("Wrong input!");
            return;
        }
            switch(c){
                case '1':

                    int x1 = -10000;
                    int x2 = 10000;

                    a.bisection(x1,x2);
                    break;

                case '2':

                    int b = 2;
                    int p = 7;


                    long time;

                    time = System.nanoTime();
                    System.out.print(b + "^" + p + " is = " +potenz.potenzLoop(b,p));
                    System.out.println("                  ( in " + (System.nanoTime() - time) + " nanoseconds)");

                    time = System.nanoTime();
                    System.out.print("Recursive: " + potenz.potenzRecursive(b,p) + "                 ( in " + (System.nanoTime() - time) + " nanoseconds)" );
                    System.out.println();

                    time = System.nanoTime();
                    System.out.println("Recursive Efficent: " + potenz.potenzEfficent(b,p) + "        ( in " + (System.nanoTime() - time) + " nanoseconds)");
                    System.out.println();



                    /*
                    Am Beispiel 2^3:

                    Rekursiv:

                    2^3 = (2^2)*2 = (2^1)*2*2 = 2*2*2 = 8
                    3^3 = (3^2)*2 = (3^1)*3*3 = 3*3*3 = 8;

                    Effizient:

                    3^5 = (3^1) * (3^2) * (3^2) = 3 * (3^1) * (3^1)


                     */

                    break;

                case '3':
                    int limit = 3;


                    pattern.printPattern(limit);
                    break;



                case '4':

                    int prim = 17;

                    if(prim <= 0){
                        System.out.println("Wrong input!");
                    }

                    if(prime.primCheck(prim))
                        System.out.println(prim + " is a prime number!");
                    else
                        System.out.println(prim + " is no prime number!");
                    break;

                case '5':
                    int [] primeNumbers;
                    int [] primeNumbersOptimized;
                    System.out.println("Enter the limit to check for primes: ");

                    limit = 50;

                    if(limit > 1){

                        primeNumbers = prime.findPrimes(limit);


                        System.out.println("Found " + primeNumbers.length + " primes between 1 - " + limit);
                        for(Integer i : primeNumbers){
                            System.out.print(i + " ");
                        }

                        System.out.println();

                    }
                    System.out.println();
                    break;


                case '6':

                    int steps = 0;
                    int stepSize = 0;

                    System.out.println("Enter the amount of Steps:");
                    steps = 5000;
                    System.out.println("Enter the stepsize: ");
                    stepSize = 100;
                    prime.timeForFindPrimes(steps, stepSize);
                    break;
                case '7':

                    steps = 0;

                    System.out.println("Enter the amount of Steps:");
                    steps = 400000;
                    prime.timeForFindDoublePrimes(steps);
                    break;


            }

        System.out.println();
    }



}
