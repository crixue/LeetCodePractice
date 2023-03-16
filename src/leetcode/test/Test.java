package leetcode.test;

import java.util.Random;

public class Test {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void quickSort(int[] nums) {
        int len = nums.length;

        quickSort(nums, 0, len-1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        int rand = left + new Random(System.currentTimeMillis()).nextInt(right - left + 1);
        swap(nums, rand, left);
        int pivot = nums[left];

        // lt < pivot, eqs == pivot, gt > pivot
        //[left+1, lt] [lt+1, i) [gt, right]
        int lt = left, gt = right + 1, i = left + 1;
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
        swap(nums, lt, left);

        quickSort(nums, left, lt-1);
        quickSort(nums, gt, right);
    }


    public void selectSort(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < len; j++) {
                if(nums[j] < nums[minimum]) {
                    minimum = j;
                }
            }
            swap(nums, minimum, i);
        }
    }
    public void insertSort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            for (int j = i-1; j >= 0; j--) {
                if(nums[j] > temp) {
                    swap(nums, j, j+1);
                } else {
                    break;
                }
            }
        }
    }

    public void bubbleSort(int[] nums) {
        boolean sorted = true;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if(nums[j-1] > nums[j]) {
                    swap(nums, j-1, j);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }

        int mid = (right - left) /2 + left;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        if(nums[mid] <= nums[mid+1]) {
            return;
        }

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        for(int i=left, j=mid+1, k=left; k <= right; k++) {
            if(i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }

    }

    public void mergeSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len-1, temp);
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr1 = {4, 7, 8, 6, 5, 1, 2, 3};
        test.selectSort(arr1);
        for (int i :
                arr1) {
            System.out.println(i);
        }
    }

}
