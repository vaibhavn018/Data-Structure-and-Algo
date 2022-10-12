public class Dp_01_Fib {
    // Using recursion -- O(2^n) time and O(n) space.
    public static long fibRec(int n) {
        if(n<2) {
            return n;
        }

        return fibRec(n-1) + fibRec(n-2);
    }

    // Using dp -- O(n) time and O(n+n) space.
    // Bottom up approach
    public static long fib(int n, long []dp) {
        if(n<2) {
            return n;
        }

        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }

    // Using dp -- O(n) time and O(n) space.
    // Top down approach
    public static long fib(int n) {
        long [] dp = new long[n+1];
        dp[1] = 1;

        for(int i=2;i<=n;i++) {
            dp[i] += dp[i-1]; 
            dp[i] += dp[i-2];
        }
        return dp[n];
    }

    // Space optimizing -- O(n) time.
    public static long fibIt(int n) {
        long f = 0;
        long s = 1;
        long answer = 0;
        for(int i=0;i<=n-2;i++) {
            answer = f + s;
            f = s;
            s = answer;
        }

        return answer;
    }
}
