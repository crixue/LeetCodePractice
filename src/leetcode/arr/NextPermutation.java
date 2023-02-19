package leetcode.arr;

import java.util.Collections;

public class NextPermutation {
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    private void sortArr(int[] nums, int startIndex) {
        for (int i = startIndex + 1; i < nums.length; i++) {
            for (int j = i; j >= startIndex + 1; j--) {
                if (nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                } else {
                    break;
                }
            }
        }

    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return;

        int i = len-2;
        for ( ; i >= 0; i--) {
            if(nums[i] >= nums[i+1]) {
                continue;
            }

            //寻找第一个相邻的升序元素,然后找到[i+1, end]后比nums[i]大的最相近的num
            int temp = i + 1;
            for (int j = i + 1; j < len; j++) {
                if(nums[j] > nums[i] && nums[temp] > nums[j]) {
                    temp = j;
                }
            }
            swap(nums, i, temp);

            //再对[i+1, end]的元素按照升序排序
            sortArr(nums, i + 1);
            break;
        }

        if (i < 0) { //都是降序
            sortArr(nums, 0);
        }

    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {1,2,3};
        nextPermutation.nextPermutation(nums);
        System.out.println(nums);
    }

}
