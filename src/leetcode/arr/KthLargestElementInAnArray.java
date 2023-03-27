package leetcode.arr;

import java.util.Random;

public class KthLargestElementInAnArray {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        return findKthLargest(nums, k, 0, len-1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        if(left >= right) {
            return nums[left];
        }

        int rand = new Random(System.currentTimeMillis()).nextInt(right-left+1) + left;
        swap(nums, left, rand);
        int pivot = nums[left];

        /**
         * lt < pivot [left+1, lt]
         * eqs == pivot [lt+1, i)
         * gt > pivot [gt, right]
         * 最后pivot和第一个区间的最后一个值进行交换
         */
        int i = left+1, lt=left, gt=right+1;
        while (i < gt) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, lt, left);
        int kSmallestIndex = nums.length - k;
        if (kSmallestIndex >= lt && kSmallestIndex < gt) {
            return pivot;
        } else if(kSmallestIndex < lt) {
            return findKthLargest(nums, k, left, lt-1);
        } else  {
            return findKthLargest(nums, k, gt, right);
        }
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        for (int i = 0; i < 100; i++) {
            int kthLargest = kthLargestElementInAnArray.findKthLargest(nums, 4);
            System.out.println(kthLargest);
        }

    }


}
