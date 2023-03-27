package leetcode.test;

import java.util.Random;

public class TestCopilot {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void mergeSort(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len-1, new int[len]);
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);

        if(nums[mid] <= nums[mid+1]) {
            return;
        }

        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }

        for (int i = left, j = mid+1, k = left; k <= right ; k++) {
            if(i == mid+1) {
                nums[k] = temp[j];
                j++;
            } else if(j == right+1) {
                nums[k] = temp[i];
                i++;
            } else if(temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }

    }

    private void quickSort(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len-1);
    }

    private static Random random = new Random(System.currentTimeMillis());

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        if(right - left <= 16) {
            insertSort(nums, left, right);
            return;
        }

        int rand = random.nextInt(right - left + 1) + left;
        swap(nums, rand, left);
        int pivot = nums[left];

        /**
         * lt < pivot: [left+1, lt]
         * eqs == pivot: (lt, i)
         * gt > pivot: [gt, right]
         */
        int i = left+1, lt = left, gt = right;
        while (i < gt) {
            if(nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, gt, i);
            }
        }
        swap(nums, left, lt);

        quickSort(nums, left, lt-1);
        quickSort(nums, gt, right);
    }

    public void insertSort(int[] nums, int left, int right) {
        int len = nums.length;

        for (int i = left+1; i <= right; i++) {
            int temp = nums[i];
            for (int j = i-1; j >= left; j--) {
                if(temp < nums[j]) {
                    swap(nums, j, j+1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        TestCopilot testCopilot = new TestCopilot();
        int[] nums = {5,2,3,1};
        testCopilot.quickSort(nums);
        System.out.println(nums.toString());
    }
}
