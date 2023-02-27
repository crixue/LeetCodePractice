package leetcode.arr;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 1) {
            return heights[0];
        }

        int[] nums = new int[len + 2];
        nums[0] = 0;
        nums[len + 1] = 0;
        System.arraycopy(heights, 0, nums, 1, len);

        Deque<Integer> stk = new ArrayDeque<>();
        int largest = 0;
        stk.addFirst(0);
        for (int i = 1; i < nums.length; i++) {
            while (nums[stk.peek()] > nums[i]) {
                Integer lastLarger = stk.pollFirst();
                largest = Math.max(nums[lastLarger] * (i - stk.peek() - 1), largest);
            }
            stk.addFirst(i);
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int i = largestRectangleInHistogram.largestRectangleArea(nums);
        System.out.println(i);

    }
}
