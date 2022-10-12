
import java.util.*;
// Problem link
// https://leetcode.com/problems/triangle/submissions/
public class Triangle {
    static int minTotal(List<List<Integer>> list, int i, int j) {
        if (i == list.size() - 1) {
            return list.get(i).get(j);
        }

        int down = list.get(i).get(j) + minTotal(list, i + 1, j);
        int dia = list.get(i).get(j) + minTotal(list, i + 1, j + 1);

        return Math.min(down, dia);
    }

    static int minTotal(List<List<Integer>> list, int i, int j, Integer[][] dp) {
        if (i == list.size() - 1) {
            return list.get(i).get(j);
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int down = list.get(i).get(j) + minTotal(list, i + 1, j);
        int dia = list.get(i).get(j) + minTotal(list, i + 1, j + 1);

        return dp[i][j] = Math.min(down, dia);
    }

    static int minTotal(List<List<Integer>> list) {
        int[][] dp = new int[list.size()][list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            dp[list.size() - 1][i] = list.get(list.size() - 1).get(i);
        }
        for (int i = list.size() - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = list.get(i).get(j) + dp[i + 1][j];
                int dia = list.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, dia);
            }
        }

        return dp[0][0];
    }

    static int minTotalOpt(List<List<Integer>> list) {
        int[] dp = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            dp[i] = list.get(list.size() - 1).get(i);
        }
        for (int i = list.size() - 2; i >= 0; i--) {
            int[] newDp = new int[list.size()];
            for (int j = i; j >= 0; j--) {
                int down = list.get(i).get(j) + dp[j];
                int dia = list.get(i).get(j) + dp[j + 1];
                newDp[j] = Math.min(down, dia);
            }
            dp = newDp;
        }

        return dp[0];
    }

    public static void main(String[] args) {
    boolean a = true;
    boolean b = false;
    boolean c = a || b;
    System.out.println(c);
    }

}
