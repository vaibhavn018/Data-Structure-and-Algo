import java.util.*;

public class Grid {

    static int num = 0;

    static long noOfWays(int m, int n, HashMap<String, Long> map) {
        String s = m + "," + n;
        String s2 = n + "," + m;
        if (m == 1 || n == 1) {
            return 1;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (map.containsKey(s2)) {
            return map.get(s2);
        }

        map.put(s, noOfWays(m - 1, n, map) + noOfWays(m, n - 1, map));
        return map.get(s);
    }

    static long noOfWays(int m, int n, long[][] dp) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        dp[m][n] = noOfWays(m - 1, n, dp) + noOfWays(m, n - 1, dp);
        return dp[m][n];
    }

    static long noOfWays(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        long[][] dp = new long[m + 1][n + 1];
        dp[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    static int noOfWays(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        int left = noOfWays(grid, i-1, j, dp);
        int right = noOfWays(grid, i, j-1, dp);

        return left + right;
    }

    public static void main(String[] args) {
        int m = -18, n = -180;
        // System.out.println(noOfWays(m, n, new HashMap<>()));
        // System.out.println(noOfWays(m, n, new long[m+1][n+1]));
        // System.out.println(noOfWays(m, n));

        int[][] grid = {
            {0,0,0},
            {0,0,0},
            {0,0,0},
        };

        // System.out.println(noOfWays(grid, grid.length-1, grid[0].length-1));
        int i =0;
        for(i=0;i<10;i++) {
            continue;
        }
        System.out.println(i);

    }
}
