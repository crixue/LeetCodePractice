package leetcode.sort;

import java.util.Random;

/**
 * 参考： https://suanfa8.com/quick-sort/quick-sort-three-ways
 * 方式：三路排序
 * 1. 最基本的是划分区间，然后递归不同的区间
 * 2. 选择pivot元素采用随机选择的方式，避免 数组的极端案例：顺序数组 和 逆序数组
 * 3. 三路排序将数组划分成三个区间：lt严格小于pivot的区间； 严格等于pivot的区间； gt严格大于pivot的区间
 *
 */

public class QuickSort {

    private static final Random rand = new Random(System.currentTimeMillis());

    public static void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        int radIdx = left + rand.nextInt(right - left + 1);
        swap(nums, left, radIdx);
        int pivot = nums[left];
        /**
         * 三个区间：
         * lt: nums[left+1, lt], 当i值小于pivot，交换i和第二个区间的第一个位置交换，即lt+1
         * eq: nums(lt, i), 当前位置不动
         * gt: nums[gt, right], 当值大于pivot，交换i到第三个区间的第一个值的前一个值，即gt-1
         *
         * 最后交换pivot值：交换left和第一个区间的最后一个值
         */

        int lt = left;
        int i = left + 1;
        int gt = right + 1;

        while (i < gt) {
            if(nums[i] < pivot) {
                lt++;
                swap(nums, i , lt);
                i++;
            } else if(nums[i] == pivot) {
                i++;
            } else if(nums[i] > pivot) {
                gt--;
                swap(nums, i, gt);
            }
        }

        swap(nums, left, lt);

        quickSort(nums, left, lt-1);
        quickSort(nums, gt, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{-1, 3, 12, 89, -4, 9};
        int[] arr = new int[]{-1, 3, 3, 2, 4, 1, 3, 5, 2, 1};

        quickSort(arr, 0, arr.length-1);
        for (int num:
             arr) {
            System.out.println(num);
        }

    }

}
