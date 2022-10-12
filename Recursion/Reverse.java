public class Reverse {
    static int answer = 0;
    public static void reverseNum1(int num) {
        if(num<=0) {
            return ;
        }

        int lastDigit = num % 10;                           // 3456
        num /= 10;
        answer = answer * 10 + lastDigit;
        reverseNum1(num);
    }
    
    static int reverseNum2(int num) {
        return helper(num, 0);
    }



    private static int helper(int num, int pow) {
        if(num <=0) {
            return num;
        }

        int lastDigit = num % 10;
        System.out.println(lastDigit);
        Math.log10(100);
        return  helper(num/10, pow+1)+ (lastDigit * (int) Math.pow(10, pow));

    }

    public static void main(String[] args) {
        // reverseNum1(123);
        // System.out.println(answer);
        System.out.println(reverseNum2(123));
    }
}
