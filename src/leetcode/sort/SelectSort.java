package leetcode.sort;


/**
 * 基本思路： 每一轮通过扫描所有未排序的数组的值，选择 最小 的哪一个值交换到未排序的最前面，经过若干个次排定这个数组
 * 
 */
public class SelectSort {

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void selectSort(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            //循环不变量[0,i)有序
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 选择区间 [i..len - 1] 里最小的元素的索引，交换到下标 i
                if(nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }

    }

    public static void main(String[] args) {
                int[] arr = new int[]{-1, 3, 12, 89, -4, 9};
//        int[] arr = new int[]{-1, 3, 3, 2, 4, 1, 3, 5, 2, 1};

        selectSort(arr);
        for (int num:
                arr) {
            System.out.println(num);
        }
    }

}
