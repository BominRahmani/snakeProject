import java.util.Random;

public class Snake {
    int size;
    int score;
    char [] [] board;

    public Snake(){
    board = new char[20][20];
    size = 1;
    score = 0;
    }

    //populate the board
    public void BoardSetUp(int[][] board) {
        for(int x = 0; x < board.length;x++){
            for (int i = 0; i < board[0].length; i++) {
                board[x][i] = '-';
            }
        }
        board[(int)Math.random()* 20+1][(int)Math.random()*20 + 1] = 's';
    }
    

}
