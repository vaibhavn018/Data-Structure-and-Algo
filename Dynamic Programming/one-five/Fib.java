public class Fib {
    static long fib(int n, long []dp) {
        if(n<2) {
            return n;
        }

        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }

    static long fib(int n) {
        long [] dp = new long[n+1];
        dp[1] = 1;

        for(int i=2;i<=n;i++) {
            dp[i] += dp[i-1]; 
            dp[i] += dp[i-2];
        }
        return dp[n];
    }

    static long fibIt(int n) {
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

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(fib(n, new long[n+1]));
        System.out.println(fib(n));
        System.out.println(fibIt(n));
    }
}
