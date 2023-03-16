package leetcode.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int len = s.length(), longestLen = 0, curValidLen = 0;
        if (len == 0) {
            return 0;
        }
        int[] arr = new int[len];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
                continue;
            }
            if (!stk.isEmpty()) {
                Integer validIndex = stk.poll();
                arr[validIndex] = 1;
                arr[i] = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) {
                curValidLen++;
            } else {
                longestLen = Math.max(longestLen, curValidLen);
                curValidLen = 0;
            }
        }
        longestLen = Math.max(longestLen, curValidLen);
        return longestLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String str = "()(()";
        int i = longestValidParentheses.longestValidParentheses(str);
        System.out.println(i);
    }
}
