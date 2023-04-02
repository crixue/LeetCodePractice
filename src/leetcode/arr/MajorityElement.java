package leetcode.arr;

import java.util.Random;

public class MajorityElement {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int majorityElement(int[] nums) {
        int left = 0, right = nums.length - 1, midIndex = (left + right) / 2;

        while (true) {
            /**
             * lt < pivot:[left+1, lt]
             * eqs == pivot:(lt,i)
             * gt > pivot:[gt, right]
             */
            int rand = new Random(System.currentTimeMillis()).nextInt(right - left + 1) + left;
            swap(nums, rand, left);
            int pivot = nums[left];

            int lt = left, gt = right + 1, i = left + 1;
            while (i < gt) {
                if(nums[i] < pivot) {
                    lt++;
                    swap(nums, lt, i);
                    i++;
                } else if(nums[i] == pivot) {
                    i++;
                } else {
                    gt--;
                    swap(nums, gt, i);
                }
            }

            swap(nums, left, lt);
            if(midIndex >= lt && midIndex < gt) {
                return pivot;
            } else if(midIndex < lt) {
                right = lt-1;
            } else {
                left = gt;
            }
        }

    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = new int[]{3,2,3};
        int i = majorityElement.majorityElement(nums);
        System.out.println(i);
    }

}
