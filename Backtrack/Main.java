public class Main {
    static long fib(int n, long[] dp) {
        if(dp[n] != 0) {
            return dp[n];
        }

        if(n<2) {
            return n;
        }
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 100;
        long[] dp = new long[n+1];
        System.out.println(fib(n, dp));
        long s =0;
        long a = 1;
        long answer = 0;
        for(int i=0;i<=n-2;i++) {
            answer = s + a;
            s = a;
            a = answer;
        }
        System.out.println(answer);
    }
}

