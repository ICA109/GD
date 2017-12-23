public class ChkConnect4 {
    public static void main(String[] args) {
        //Suppose we have 2 players; player 'x' and player 'y'
        char[][] board = new char[6][7];  //Standard 6-by-7 game board

        char[][] hBoard = new char[5][5]; //Test horizontal
        hBoard [0][0] = 'x';
        hBoard [0][1] = 'x';
        hBoard [0][2] = 'x';
        hBoard [0][3] = 'x';

        char[][] vBoard = new char[5][5]; //Test vertical
        vBoard [1][4] = 'x';
        vBoard [2][4] = 'x';
        vBoard [3][4] = 'x';
        vBoard [4][4] = 'x';

        char[][] d2Board = new char[5][5]; //Test upward diagonal
        d2Board [4][1] = 'x';
        d2Board [3][2] = 'x';
        d2Board [2][3] = 'x';
        d2Board [1][4] = 'x';

        char[][] d1Board = new char[5][5]; //Test downward diagonal
        d1Board [1][1] = 'x';
        d1Board [2][2] = 'x';
        d1Board [3][3] = 'x';
        d1Board [4][4] = 'x';

        System.out.println(playerWins('x', hBoard));
        System.out.println(playerWins('x', vBoard));
        System.out.println(playerWins('x', d2Board));
        System.out.println(playerWins('x', d1Board));

    }

    public static boolean playerWins(char player, char[][] gameBoard) {
        //Check horizontal
        for (int row=0; row<gameBoard.length; row++) {
            for (int col=0; col<gameBoard[row].length-3; col++) {
                if (gameBoard[row][col] == player && gameBoard[row][col+1] == player && gameBoard[row][col+2] == player && gameBoard[row][col+3] == player) {
                    System.out.println("Case 1");
                    return true;
                }
            }
        }

        //Check vertical
        for (int row=0; row<gameBoard.length-3; row++) {
            for (int col=0; col<gameBoard[row].length; col++) {
                if (gameBoard[row][col] == player && gameBoard[row+1][col] == player && gameBoard[row+2][col] == player && gameBoard[row+3][col] == player) {
                    System.out.println("Case 2");
                    return true;
                }
            }
        }

        //Check diagonal (LR up)
        for (int row=3; row<gameBoard.length; row++) {
            for (int col=0; col<gameBoard[row].length-3; col++) {
                if (gameBoard[row][col] == player && gameBoard[row-1][col+1] == player && gameBoard[row-2][col+2] == player && gameBoard[row-3][col+3] == player) {
                    System.out.println("Case 3");
                    return true;
                }
            }
        }

        //Check diagonal (LR down); trick is to notice it starts from (3,3) since you can't get a winning diagonal with anything less...
        for (int row=3; row<gameBoard.length; row++) {
            for (int col=3; col<gameBoard[row].length; col++) {
                if (gameBoard[row][col] == player && gameBoard[row-1][col-1] == player && gameBoard[row-2][col-2] == player && gameBoard[row-3][col-3] == player) {
                    System.out.println("Case 4");
                    return true;
                }
            }
        }
        return false;   //Default if no solution found
    }
}
