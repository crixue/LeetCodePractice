package leetcode.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    class MyQueue {

        private Deque<Integer> inboundStk;
        private Deque<Integer> outboundStk;
        int size;

        public MyQueue() {
            inboundStk = new ArrayDeque<>();
            outboundStk = new ArrayDeque<>();
            size = 0;
        }

        public void push(int x) {
            inboundStk.push(x);
            size++;
        }

        public int pop() {
            if(size == 0) {
                return Integer.MIN_VALUE;
            }

            if (outboundStk.isEmpty()) {
                while (!inboundStk.isEmpty()) {
                    outboundStk.push(inboundStk.pop());
                }
            }
            Integer popVal = outboundStk.pop();
            size--;
            return popVal;
        }

        public int peek() {
            if(size == 0) {
                return Integer.MIN_VALUE;
            }
            if (outboundStk.isEmpty()) {
                while (!inboundStk.isEmpty()) {
                    outboundStk.push(inboundStk.pop());
                }
            }
            return outboundStk.peek();
        }

        public boolean empty() {
            if(size == 0) {
                return true;
            }
            return false;
        }
    }

}
