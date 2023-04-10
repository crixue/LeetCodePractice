package leetcode.arr;

import java.util.Arrays;
import java.util.Random;

public class LeastNumbersInArray {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static Random random = new Random(System.currentTimeMillis());

    private void getLeastNumbers(int[] nums, int k, int left, int right) {
        if(left >= right) {
            return;
        }

        int rand = random.nextInt(right - left + 1) + left;
        swap(nums, left, rand);
        int pivot = nums[left];

        /**
         * lt: [left+1, lt];
         * eqs: (lt, i)
         * gt: [gt, right]
         */
        int lt = left, gt = right + 1, i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
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

        swap(nums, lt, left);
        if(k >= lt && k < gt) {
            return;
        } else if(k < lt) {
            getLeastNumbers(nums, k, left, lt-1);
        } else {
            getLeastNumbers(nums, k, gt, right);
        }

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        getLeastNumbers(arr, k, 0, arr.length-1);
        int[] range = Arrays.copyOfRange(arr, 0, k);
        return range;
    }

    public static void main(String[] args) {
        LeastNumbersInArray leastNumbersInArray = new LeastNumbersInArray();
        int[] nums = {0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};
        int[] leastNumbers = leastNumbersInArray.getLeastNumbers(nums, 75);
        System.out.println(Arrays.toString(leastNumbers));
    }

}
