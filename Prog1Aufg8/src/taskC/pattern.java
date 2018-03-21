package taskC;

public class pattern {

    public static void printPattern(int n){

        if ( n==-1 )
            return;

        printPattern( n-1 );

        for( int i = 0; i <= n; i++ )
            System.out.print( n );

        System.out.println();

        printPattern( n-1 );
    }


}
