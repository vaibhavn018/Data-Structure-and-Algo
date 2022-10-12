import java.util.HashMap;

public class MinimumPathSum {

    static int min(int[][] grid) {
        return helper(grid, 0, 0, new HashMap<>());
    }

    static int helper(int[][] grid, int m, int n, HashMap<String, Integer> map) {
        String s1 = m + "," + n;
        if (map.containsKey(s1)) {
            return map.get(s1);
        }
        if (m == grid.length - 1 && n == grid.length - 1) {
            return grid[m][n];
        }

        if (n == grid.length - 1) {
            map.put(s1, grid[m][n] + helper(grid, m + 1, n, map));
            return map.get(s1);
        }
        if (m == grid.length - 1) {
            map.put(s1, grid[m][n] + helper(grid, m, n + 1, map));
            return map.get(s1);
        }

        map.put(s1, grid[m][n] + Math.min(helper(grid, m + 1, n, map), helper(grid, m, n + 1, map)));
        return map.get(s1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 3 },
                { 1, 3, 1 },
                { 1, 1, 1 }
        };
        System.out.println(min(grid));
    }
}
