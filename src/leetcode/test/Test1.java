package leetcode.test;

import leetcode.tree.git.TreeNode;

import java.util.*;

public class Test1 {

        private int min;
        private Deque<Integer> stk;
        private Deque<Integer> diffStk;

        public Test1() {
            this.min = Integer.MAX_VALUE;
            this.stk = new ArrayDeque<>();
            this.diffStk = new ArrayDeque<>();
        }

        public void push(int val) {
            if (stk.size() == 0 || val <= min) {
                stk.push(val);
                diffStk.push(0);
                min = val;
            } else {
                stk.push(val);
                diffStk.push(val - min);
            }
        }

        public void pop() {
            stk.pop();
            diffStk.pop();
            if (stk.size() == 0) {
                min = Integer.MAX_VALUE;
            } else {
                min = stk.peekFirst() - diffStk.peekFirst();
            }
        }

        public int top() {
            return stk.peekFirst();
        }

        public int getMin() {
            return this.min;
        }


    public static void main(String[] args) {

        System.out.println(~ 30);

    }

}
