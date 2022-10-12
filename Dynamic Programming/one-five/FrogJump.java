import java.util.*;

public class FrogJump {
    // Using plane recursion. 2^n time, n space.
    static int minLossEnergy(int n, int[] nums) {
        if (n == 0) {
            return 0;
        }

        int left = minLossEnergy(n - 1, nums) + Math.abs(nums[n - 1] - nums[n]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = minLossEnergy(n - 2, nums) + Math.abs(nums[n - 2] - nums[n]);
        }
        return Math.min(left, right);
    }

    // Using memo. n time, 2n space
    static int minLossEnergy(int n, int[] nums, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        }

        int left = minLossEnergy(n - 1, nums) + Math.abs(nums[n - 1] - nums[n]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = minLossEnergy(n - 2, nums) + Math.abs(nums[n - 2] - nums[n]);
        }

        dp[n] = Math.min(left, right);
        return dp[n];
    }

    // Using Tabulation. n time - n space.
    static int minLossTab(int n, int[] nums) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int left = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(nums[i] - nums[i - 2]);
            }
            dp[i] = Math.min(right, left);
        }
        return dp[n];
    }

    // Space optimizing
    static int minLossRem(int n, int[] nums) {
        int f = 0;
        int s = 0;

        for (int i = 1; i <= n; i++) {
            int left = s + Math.abs(nums[i] - nums[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = f + Math.abs(nums[i] - nums[i - 2]);
            }
            int cur = Math.min(left, right);
            f = s;
            s = cur;
        }
        return s;
    }

    // When k jump
    static int kJump(int n, int k, int[] nums) {
        if (n == 0) {
            return 0;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= k && n - i >= 0; i++) {
            int cur = Math.abs(nums[n] - nums[n - i]) + kJump(n - i, k, nums);
            if (cur < answer) {
                answer = cur;
            }
        }

        return answer;
    }

    static int kJump(int n, int k, int[] nums, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }

        if (n == 0) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= k && n - i >= 0; i++) {
            int cur = Math.abs(nums[n] - nums[n - i]) + kJump(n - i, k, nums);
            if (cur < answer) {
                answer = cur;
            }
        }
        dp[n] = answer;
        return dp[n];
    }

    static int kJump(int n, int[] nums, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int answer = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                int cur = Math.abs(Math.abs(nums[i] - nums[i - j])) + dp[i - j];
                if (cur < answer) {
                    answer = cur;
                }
            }
            dp[i] = answer;
        }
        return dp[n];
    }

    static int kJumpSpaceOptimizing(int n, int[] nums, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int answer = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                int cur = Math.abs(Math.abs(nums[i] - nums[i - j])) + dp[i - j];
                if (cur < answer) {
                    answer = cur;
                }
            }
            dp[i] = answer;
        }
        return dp[n];
    }

    static int helper(int n, int[] nums) {
        if (n == nums.length - 1) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        int jumpCount = nums[n];
        for (int i = n + 1; jumpCount > 0 && i < nums.length; i++, jumpCount--) {
            if(nums[i]==0) {
                continue;
            }
            int cur = 1 + helper(i, nums);
            if (cur < count) {
                count = cur;
            }
        }

        return count;
    }

    static int helper(int n, int[] nums, int[] dp) {
        if(dp[n] != 0) {
            return dp[n];
        }
        if (n == nums.length - 1) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        int jumpCount = nums[n];
        for (int i = n + 1; jumpCount > 0 && i < nums.length; i++, jumpCount--) {
            if(nums[i]==0 && !(nums.length-1 == n)) {
                continue;
            }
            int cur = 1 + helper(i, nums, dp);
            if (cur < count) {
                count = cur;
            }
        }
        dp[n] = count;
        return count;
    }

    public static void main(String[] args) {
        // int[] nums = { 10, 2, 1, 40, 3, 7 };
        // int n = nums.length - 1;
        // int[] dp = new int[n + 1];
        // int[] newDp = new int[n + 1];
        // int k = 4;
        // Arrays.fill(dp, -1);
        // Arrays.fill(newDp, -1);
        // System.out.println(minLossEnergy(n, nums));
        // System.out.println(minLossEnergy(n, nums, dp));
        // System.out.println(minLossTab(n, nums));
        // System.out.println(minLossRem(n, nums));
        // System.out.println(kJump(n, k, nums));
        // System.out.println(kJump(n, k, nums, newDp));
        // System.out.println(kJump(n, nums, k));

        int[] arr = {2, 2, 1, 1, 4 };
        System.out.println(helper(0, arr));
        System.out.println(helper(0, arr, new int[arr.length+1]));
    }
}
