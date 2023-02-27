package leetcode.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) {
            return "0";
        }

        Deque<Character> stk = new ArrayDeque<>();
        stk.addFirst(num.charAt(0));
        for (int i = 1; i < len; i++) {
            while (!stk.isEmpty() && k > 0 && num.charAt(i) < stk.peek()) {
                stk.removeFirst();
                k--;
            }
            stk.addFirst(num.charAt(i));
        }

        while (k > 0) {
            stk.removeFirst();
            k--;
        }

        boolean startWithZero = stk.peekLast() == '0';
        StringBuilder sb = new StringBuilder();
        int sz = stk.size();
        for (int i = 0; i < sz; i++) {
            if (startWithZero && stk.peekLast() == '0') {
                stk.pollLast();
                continue;
            }
            startWithZero = false;
            sb.append(stk.pollLast());
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String s1 = "10219";
        String s = removeKDigits.removeKdigits(s1, 1);
        System.out.println(s);
    }

}
