import java.util.*;



public class Test {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }
    
    private void backTrack(char[][] board, int row , int col) {
        if(row>= board.length) {
            return;
        }
        
        if(col>=9) {
            backTrack(board, row+1, 0);
            return;
        }
        
        if(board[row][col] != '.') {
            backTrack(board, row, col+1);
            return;
        }
        
        for(int num =1; num<=9;num++) {
            char charNum = (char) (num+'1');
            if(isOk(board, row, col, charNum)) {
                board[row][col] = charNum;
                backTrack(board, row, col+1);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isOk(char[][] board, int row, int col, char ch) {
        int i, j;
        for(i=0;i<board.length;i++) {
            if(board[row][i] == ch) {
                return false;
            }
            if(board[i][col] == ch) {
                return false;
            }
        }
        
        for(i=row-(row%3);i<row-(row%3) + 2;i++) {
            for(j=col-(col%3);j<col-(col%3) + 2;j++) {
                if(board[row][col] == ch) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Test t  = new Test();
        char[][] ch = {
            {'o', 'a', 'b', 'n'},
            {'o', 't', 'a', 'e'},
            {'a', 'h', 'k', 'r'},
            {'a', 'f', 'l', 'v'}
        };

        String[] words = {"oa", "oaa" };
        System.out.println(t.findWords(ch, words));
    }
    public List<String> findWords(char[][] board, String[] words) {
        Arrays.sort(words);
        List<String> res = new ArrayList<>();
        for(int w=0;w<words.length;w++) {
            if(w>0 && words[w].equals(words[w-1])) {
                continue;
            }
            boolean[][] vis = new boolean[board.length][board[0].length];
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[i].length;j++) {
                    if(board[i][j] == words[w].charAt(0)) {
                        if(backTrack(board, words[w], 0, i, j, vis)) {
                            res.add(words[w]);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    boolean backTrack(char[][] board, String word, int k, int i, int j, boolean[][] vis) {
        if(k==word.length()) {
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(k) || vis[i][j]) {
            return false;
        }
        
        vis[i][j] = true;
        if(backTrack(board, word, k+1, i+1, j, vis) || backTrack(board, word, k+1, i-1, j, vis) || backTrack(board, word, k+1, i, j+1, vis) || backTrack(board, word, k+1, i, j-1, vis)) {
            return true;
        }
        
        vis[i][j] = false;
        return false;
    }
}
