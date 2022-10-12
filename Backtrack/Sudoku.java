import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {
        int[][] board = new int[9][9];
    //     int [][] board = {  {7, 0, 0, 0, 0, 0, 2, 0, 0},   
    //                         {4, 0, 2, 0, 0, 0, 0, 0, 3},   
    //                         {3, 0, 0, 2, 0, 1, 0, 0, 0},   
    //                         {0, 0, 0, 1, 8, 0, 0, 9, 7},   
    //                         {0, 0, 9, 0, 7, 0, 6, 0, 0},   
    //                         {6, 5, 0, 0, 3, 2, 0, 0, 1},   
    //                         {0, 0, 0, 4, 0, 9, 0, 0, 0},   
    //                         {5, 0, 0, 0, 0, 0, 1, 0, 6},   
    //                         {0, 0, 6, 0, 0, 0, 0, 0, 8}   
    // };

        // int count = sudoku(board, 0, 0);
        System.out.println(sudoku(board));
        display(board);
    }

    private static int sudoku(int[][] board, int i, int j) {
        if (i == board.length) {
            display(board);
            return 1;
        }

        if (j == board.length) {
            return sudoku(board, i + 1, 0);
            
        }

        if(board[i][j] != 0) {
            return sudoku(board, i, j+1);
            
        }
        int count = 0;
        for (int num = 1; num <= 9; num++) {
            if (isOk(board, num, i, j)) {
                board[i][j] = num;
                count += sudoku(board, i, j + 1);
                board[i][j] = 0;
            }
        }
        return count;
    }

    private static boolean isOk(int[][] board, int num, int i, int j) {
        int m, n;
        // vertical and horizontal.
        for (m = 0; m < board.length; m++) {
            if (board[i][m] == num) {
                return false;
            }

            if (board[m][j] == num) {
                return false;
            }
        }

        for (m = i - (i % 3); m <= i - (i % 3) + 2; m++) {
            for (n = j - (j % 3); n <= j - (j % 3) + 2; n++) {
                if (board[m][n] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] i : board) {
            System.out.println(Arrays.toString(i));
        }
    }


    private static boolean sudoku(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                if(board[i][j] == 0) {
                    for(int num=1;num<10;num++) {
                        if(isOk(board, num, i, j)) {
                            board[i][j] = num;
                            if(sudoku(board)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
