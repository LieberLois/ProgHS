public class Board {

    // i is y - j is x
    private final int HEIGTH = 8;
    private final int WIDTH = 8;
    private char[][] board = new char[HEIGTH][WIDTH];

    Board(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }
    }


    String printBoard(){
        String s = "12345678\n";

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                s += board[i][j];
            }
            s += '\n';
        }

        s += "12345678\n";

        return s;
    }

    boolean placeSign(int x, char sign){
        for(int i = HEIGTH-1; i >= 0; i--){
            if(board[i][x] == '.'){
                board[i][x] = sign;
                return true;
            }
        }
        System.out.println("Try again!");
        System.out.println();
        return false;
    }

    boolean checkWin(){
        if(checkHorizontal() || checkVertical() || checkDiagonal()){
            return true;
        } else {
            return false;
        }
    }

    boolean checkHorizontal(){
        int counter;
        char sign;

        for (int y = 0; y <= HEIGTH-1; y++) {

            counter = 0;
            sign = board[y][0];

            for(int i = 0; i <= WIDTH-1; i++){
                if(board[y][i] == sign && sign != '.'){
                    counter++;
                }else{
                    sign = board[y][i];
                    counter = 1;
                }
                if(counter >= 4){
                    return true;
                }
            }
        }

        return false;
    }

    boolean checkVertical(){

        int counter;
        char sign;

        for (int x = 0; x <= WIDTH-1; x++) {
            counter = 0;
            sign = board[0][x];

            for(int i = 0; i <= HEIGTH-1; i++){
                if(board[i][x] == sign && sign != '.'){
                    counter++;
                }else{
                    counter = 1;
                    sign = board[i][x];
                }
                if(counter >= 4){
                    return true;
                }

            }
        }
        return false;
    }

    boolean checkDiagonal(){
        boolean checking = false;

        for(int i = 0; i <= WIDTH-1; i++){
            for(int j = 0; j <= HEIGTH-1; j++){
                if(checkDiagonalLeftToRight(i,j)){
                    checking = true;
                    break;
                }
                if(checkDiagonalRightToLeft(i,j)) {
                    checking = true;
                    break;
                }
            }
        }

        return checking;
    }

    boolean checkDiagonalLeftToRight(int x, int y){
        int counter;
        char sign;

                counter = 0;
                sign = board[y][x];


                while (x < 8 && y < 8) {
                    if(board[y][x] == sign && sign != '.'){
                        counter++;
                    }else{
                        sign = board[y][x];
                        counter = 1;
                    }
                    if(counter >= 4){
                        return true;
                    }

                    x++;
                    y++;

                }


        return false;
    }

    boolean checkDiagonalRightToLeft(int x, int y){
        int counter;
        char sign;

        counter = 0;
        sign = board[y][x];


        while (x >= 0 && y < 8) {
            if(board[y][x] == sign && sign != '.'){
                counter++;
            }else{
                sign = board[y][x];
                counter = 1;
            }
            if(counter >= 4){
                return true;
            }

            x--;
            y++;
        }

        return false;
    }

}
