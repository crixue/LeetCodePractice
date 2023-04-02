package leetcode.others;

import java.util.PriorityQueue;

public class LargestNumber {

    private int mergeTwoIntStr(int o1, int o2) {
        if(o1 == 0) {
            o1 = 10;
        } else if(o2 == 0) {
            o2 = 10;
        }

        int digital = 0, temp = o2;
        while (temp != 0) {
            temp = temp / 10;
            digital++;
        }

        while (digital > 0) {
            o1 = o1 * 10;
            digital--;
        }

        return o1 + o2;
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
            return mergeTwoIntStr(o2, o1) - mergeTwoIntStr(o1, o2);
        });

        boolean allZero = true;
        for (int i = 0; i < len; i++) {
            if(nums[i] != 0) allZero = false;
            pq.add(nums[i]);
        }
        if (allZero) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(largestNumber.largestNumber(nums));
    }

}
