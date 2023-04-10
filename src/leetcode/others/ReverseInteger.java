package leetcode.others;

public class ReverseInteger {

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        if (x == 0) {
            return 0;
        }

        x *= sign;
        int n = 0;
        while (x > 0) {
            int temp = x % 10;
            x /= 10;
            if((sign == 1 && n > Integer.MAX_VALUE / 10) || (sign == 1 && n == Integer.MAX_VALUE / 10 && temp >= Integer.MAX_VALUE % 10)) {
                return 0;
            } else if((sign == -1 && -n < Integer.MIN_VALUE / 10) || (sign == -1 && -n == Integer.MIN_VALUE / 10 && temp <= Integer.MIN_VALUE % 10)) {
                return 0;
            }
            n = n * 10 + temp;
        }

        return n * sign;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-1463847412));
    }

}
