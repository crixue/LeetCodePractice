package leetcode.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }


    /**
     Res: int[]
     int[0]-calcuate results; int[1] ')' index
     */
    private int[] _calculate(String s, int start) {
        int sz = s.length();

        Deque<Integer> stk = new ArrayDeque<>();
        char lastSign = '+';
        if(s.charAt(start) == '-') {
            lastSign = '-';
        }

        int n = 0;
        for(int i=start; i<sz; i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(isDigital(c)) {
                n = n * 10 + (c - '0');
                if(i != sz-1) {
                    continue;
                }
            }

            if(c == '(') {
                int[] innerRes = _calculate(s, i+1);
                i = innerRes[1];
                n = innerRes[0];
            }

            if(lastSign == '+') {
                stk.push(n);
            } else if(lastSign == '-') {
                stk.push(-n);
            } else if(lastSign == '*') {
                int last = stk.pop();
                stk.push(n * last);
            } else if(lastSign == '/') {
                int last = stk.pop();
                if(n == 0) {
                    stk.push(0);
                } else {
                    stk.push(last / n);
                }
            }

            if(c == ')') {
                int innerRes = 0;
                while(!stk.isEmpty()) {
                    innerRes += stk.pop();
                }
                return new int[]{innerRes, i};
            }
            lastSign = c;
            n = 0;
        }


        int res = n;
        while(!stk.isEmpty()) {
            res += stk.pop();
        }
        return new int[]{res, sz-1};
    }

    public int calculate(String s) {
        if(s.length() == 0) return 0;

        int[] res = _calculate(s, 0);
        return res[0];
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int calculate = calculator.calculate("1*2-3/4+5*6-7*8+9/10");
        System.out.println(calculate);
    }

}
