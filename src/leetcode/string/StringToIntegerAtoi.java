package leetcode.string;

public class StringToIntegerAtoi {

    private int mergeChar2Int(char c, int n, int signed) {
        if(signed == -1 && (-n < Integer.MIN_VALUE / 10 || (-n == Integer.MIN_VALUE / 10 && ('0' - c) <= Integer.MIN_VALUE % 10))) {
            return Integer.MIN_VALUE;
        } else if(signed == 1 && (n > Integer.MAX_VALUE / 10 || (n == Integer.MAX_VALUE / 10 && (c - '0') >= Integer.MAX_VALUE % 10))) {
            return Integer.MAX_VALUE;
        }

        return n * 10 + (c - '0');
    }

    public int myAtoi(String s) {
        int len = s.length();

        int num = 0, signed = 1;
        boolean haveReadNum = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!haveReadNum && c == '+') {
                signed = 1;
                haveReadNum = true;
            } else if (!haveReadNum && c == '-') {
                signed = -1;
                haveReadNum = true;
            } else if(c >= '0' && c <= '9') {
                num = mergeChar2Int(c, num, signed);
                if(num == Integer.MIN_VALUE || num == Integer.MAX_VALUE) {
                    return signed * num;
                }
                haveReadNum = true;
            } else if(!haveReadNum && c == ' ') {
                continue;
            } else {
                break;
            }
        }

        return signed * num;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
        String s = "-2147483649";
        int num = stringToIntegerAtoi.myAtoi(s);
        System.out.println(num);
    }

}
