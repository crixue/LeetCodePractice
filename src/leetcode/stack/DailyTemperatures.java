package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            while ((!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()])) {
                int val = i - stk.peek();
                res[stk.peek()] = val;
                stk.pop();
            }
            stk.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures.dailyTemperatures(temperatures);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
