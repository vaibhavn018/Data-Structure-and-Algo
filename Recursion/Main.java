class Main {
    static void rec(int n) {
        if (n == 1) {
            return;
        }
        rec(n - 1);
        System.out.println(n);
    }

    static int sum(int num) {
        if (num < 0) {
            return num;
        }
        return num + sum(num - 1);
    }

    static void reverseArray(int[] arr, int s, int e) {
        if (s == e) {
            return;
        }
        swap(arr, s, e);
        reverseArray(arr, s + 1, e - 1);
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

    public static String reverseString(String str, int i) {
        if(i==str.length()) {
            return "";
        }

        char ch = str.charAt(i);

        return reverseString(str, i+1) + ch;
    }

    public static boolean isPalindrome(String str, int i) {
        if(i > str.length()/2) {
            return true;
        }
        if(str.charAt(i) != str.charAt(str.length()-i-1)) {
            return false;
        }

        return isPalindrome(str, i+1);

    }

    public static int fib(int num) {
        int f = 0;
        int s = 1;
        if(num == 1) {
            return s;
        } 
        
        int ans =0;

        for(int i=0;i<=num-2;i++) {
            ans = f + s;
            f = s;
            s = ans;
        }

        return ans;
    }


    public static void main(String[] args) {
        int a = sum(10);
        System.out.println(a);
        // int c =10;
        // int b = 20;

        // c = b + c;
        // b = Math.abs(b-c);
        // c = Math.abs(c-b);

        // System.out.println(b);
        // System.out.println(c);

        // int[] arr = { 5, 4, 3, 2, 1 };
        // reverseArray(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        // String s = "abcd";
        // System.out.println(reverseString(s, 0));

        String s1 = "abcdcba";
        String s2 = new String("abcd");
        // s2 = s1;
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s1.compareTo(s2));

        // System.out.println(s2);
        System.out.println(isPalindrome(s1, 0));
        System.out.println(fib(8));

    }
}