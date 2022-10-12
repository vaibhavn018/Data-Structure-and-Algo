import java.util.Arrays;

public class MinCostHome {
    public int minCost(int[] s, int[] h, int[] row, int[] col) {
        return helper(s[0], s[1], h, row, col, new boolean[h[0]][h[1]]);
    }

    private int helper(int i, int j, int[] h, int[] row, int[] col, boolean[][] vis) {
        if (i == h[0] && j == h[1]) {
            return 0;
        }
        if (i < 0 || j < 0 || i > h[0] || j > h[1]) {
            return 0;
        }
        int up = 0, down = 0, left = 0, right = 0;
        vis[i][j] = true;
        if (i > 0) {
            up += row[i - 1] + helper(i - 1, j, h, row, col, vis);
        }
        if (j > 0) {
            left += col[j - 1] + helper(i, j - 1, h, row, col, vis);
        }
        if (i < h[0]) {
            down += row[i + 1] + helper(i + 1, j, h, row, col, vis);
        }
        if (j < h[1]) {
            right += row[j + 1] + helper(j + 1, j, h, row, col, vis);
        }
        vis[i][j] = false;
        return Math.min(Math.min(up, down), Math.min(left, right));

    }

    public static void main(String[] args) {
        String[] a = new String[] {"2", "4"};
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, "4"));
    }
}
