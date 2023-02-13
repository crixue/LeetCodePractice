package leetcode.others;

import java.util.ArrayDeque;
import java.util.Deque;

class MyBucket {
    int val;
    int stkMin;
    public MyBucket(int val, int stkMin) {
        this.val = val;
        this.stkMin = stkMin;
    }
}

public class MinStack {

    private int curMin;
    private int size;
    private Deque<MyBucket> stk;

    public MinStack() {
        curMin = Integer.MAX_VALUE;
        size = 0;
        stk = new ArrayDeque<>();
    }

    public void push(int val) {
        curMin = Math.min(curMin, val);
        MyBucket x = new MyBucket(val, curMin);
        stk.push(x);
        size++;
    }

    public void pop() {
        if(size == 0) return;
        size--;
        stk.pop();
        if(size == 0) {
            curMin = Integer.MAX_VALUE;
        }
        MyBucket x = stk.peek();
        curMin = x.stkMin;
    }

    public int top() {
        if(size == 0) return Integer.MAX_VALUE;
        MyBucket x = stk.peek();
        return x.val;
    }

    public int getMin() {
        return curMin;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        minStack.top();
        int min1 = minStack.getMin();
        System.out.println(min1);

    }

}
