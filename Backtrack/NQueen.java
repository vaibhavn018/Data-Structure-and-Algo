class NQueen {
    static int queens(int n, int i, boolean[][] nums) {
        if (i == n) {
            display(nums);
            return 1;
        }
        // System.out.println(i + n);
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (isP(i, j, nums)) {
                nums[i][j] = true;
                count = count + queens(n, i + 1, nums);
                nums[i][j] = false;
            }

        }

        return count;

    }

    static boolean isP(int i, int j, boolean[][] nums) {
        for (int a = j; a >= 0; a--) {
            if (nums[i][a]) {
                return false;
            }
        }
        for (int b = i; b >= 0; b--) {
            if (nums[b][j]) {
                return false;
            }
        }

        for (int c = i, d = j; c >= 0 && d >= 0; c--, d--) {
            if (nums[c][d]) {
                return false;
            }
        }

        for (int e = i, f = j; e >= 0 && f < nums.length; e--, f++) {
            if (nums[e][f]) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] i : board) {
            for (boolean j : i) {
                if (j) {
                    System.out.print('Q');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean queens(boolean[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                for(int k=0;k<board.length;k++) {
                    if(isP(i, j, board)) {
                        board[i][j] = true;
                        if(queens(board)) {
                            return true;
                        }
                        board[i][j] = false;
                    }
                }
                // return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[][] nums = new boolean[n][n];
        // System.out.println(queens(4, 0, nums));
        // for(int i=0;i<n;i++) {
        // for(int j=0;j<n;j++) {
        // System.out.print(nums[i][j] + " ");
        // }
        // System.out.println();
        // }
        System.out.println(queens(nums));
        display(nums);
    }
}