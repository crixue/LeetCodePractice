package leetcode.sort;


/**
 * https://suanfa8.com/basic-sorting-algorithm/insertion/introduction
 * 基本思路：每一次将一个元素 插入 到前面的有序数组中
 * 有两种方案： 1. 逐个交换
 * 2. 先暂存再后移
 *
 * 插入排序意义：数据接近有序的时候，插入排序可以很快完成。
 * 在高级排序中，接近于小区间排序的时候可以转向至插入排序
 */

public class InsertSort {

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void insertSort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 ; j--) {
                if(nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-1, 3, 12, 89, -4, 9};
        int[] arr = new int[]{-1, 3, 3, 2, 4, 1, 3, 5, 2, 1};

        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
