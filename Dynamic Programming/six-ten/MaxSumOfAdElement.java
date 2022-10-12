import java.util.Arrays;

public class MaxSumOfAdElement {
    // dp solution memo
    static int maxSum(int[] nums, int n, int[] dp) {
        if (n == 0) {
            return nums[0];
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int pick = nums[n] + maxSum(nums, n - 2, dp);
        int notPick = 0 + maxSum(nums, n - 1, dp);

        dp[n] = Math.max(pick, notPick);
        return dp[n];
    }

    // tabulation
    static int maxSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if(i>1) {
                pick += dp[i-2];
            }

            int notPick = 0 + dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length-1];
    }

    // Space optimizing

    static int maxSumOp(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1;i<nums.length;i++) {
            int pick = nums[i] + prev2;
            int notPick = 0 + prev1;
            int cur = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    public static int path(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1 && j==1) {
                    continue;
                }
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        // int[] arr = { 4, 30, 60, 40, 10, 2,90 };
        // int[] dp = new int[arr.length];
        // Arrays.fill(dp, -1);
        // System.out.println(maxSum(arr, arr.length - 1, dp));
        // System.out.println(maxSum(arr));
        // System.out.println(maxSumOp(arr));

        System.out.println(path(3, 3));
        
        
    }
}
