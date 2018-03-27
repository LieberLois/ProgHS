import java.io.IOException;
import java.util.Scanner;

public class Controller {
    static int playerTurn = 2;
    static Scanner sc = new Scanner(System.in);
    static Board board;

    public static void main(String[] args) {
        board = new Board();
        play();
    }

    private static void changePlayerTurn(){
        if(playerTurn == 1) {
            playerTurn = 2;
        } else if(playerTurn == 2){
            playerTurn = 1;
        }
    }

    private static boolean placeSign(int x){
        if(playerTurn == 1) {
            return board.placeSign(x, 'X');
        } else if(playerTurn == 2){
            return board.placeSign(x, 'O');
        }
        return false;
    }

    private static void play() {

        int temp;

        while(!board.checkWin()){
            changePlayerTurn();
            temp = 0;
            System.out.println(board.printBoard());


            while (!(temp > 0 && temp < 9)) {
                System.out.print("Player " + playerTurn + ": ");

                try {
                    temp = System.in.read() - '0';
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(!(temp > 0 && temp < 9)){
                    System.out.println();
                    System.out.println("Enter a number between 1 and 8!");
                    System.out.println();
                }
            }

            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println();

            if (!placeSign(temp-1)) {
                changePlayerTurn();
            }

        }

        System.out.println(board.printBoard());

        System.out.println("Player " + playerTurn + " wins!");



    }

}
