import java.util.*;


public class NKnight {

    public static int knight(boolean[][] board, int i, int j, int knight) {
        if(knight == board.length) {
            display(board);
            return 1;
        }
        if(i==board.length) {
            return 0;
        }

        if(j==board.length) {
            return knight(board, i+1, 0, knight);
        }

        int count = 0;

        if(isOk(board, i, j)) {
            board[i][j] = true;
            count += knight(board, i, j+1, knight+1);
            board[i][j] = false;
        }
        count += knight(board, i, j+1, knight);
        return count;
    }

    private static boolean isOk(boolean[][] board, int i, int j) {
        if(isSafe(board, i-1, j-2)) {
            if(board[i-1][j-2]) {
                return false;
            }
        }
        if(isSafe(board, i-1, j+2)) {
            if(board[i-1][j+2]) {
                return false;
            }
        }
        if(isSafe(board, i-2, j-1)) {
            if(board[i-2][j-1]) {
                return false;
            }
        }
        if(isSafe(board, i-2, j+1)) {
            if(board[i-2][j+1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSafe(boolean [][] board, int i, int j) {
        if(i>=0 && j>=0 && i<board.length && j<board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] i : board) {
            for (boolean j : i) {
                if(j) {
                    System.out.print('k');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(knight(board, 0, 0, 0));

        // char[][] ch = new char[4][4];
        // for(char []c:ch) {
        //     Arrays.fill(c, '.');
        // }
        // List<String> list = new ArrayList<>();
        // for(char []c:ch) {
        //     String a = new String(c);
        //     list.add(a);
        // }

        // System.out.println(list);

    }
}
