package leetcode.sort;

/**
 * https://suanfa8.com/merge-sort/basic-thought
 * 先拆分 在组合
 */

public class MergeSort {

    public static int[] mergeSortArr(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len-1, temp);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }


        int mid = (left + right) / 2;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);

        //优化的地方： 当第一个排序的数组的最后一个值 <= 第二个排序的数组的第一个值，合并已经完成直接返回
        if(nums[mid] <= nums[mid+1]) {
            return;
        }

        /**
         * 将两个数组进行合并: nums[left, mid] 和 nums[mid+1, right]
         * 先为复制数组进行赋值
         * 然后再将这两个数组在之前的递归当中已经排好序了
         */
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right ; k++) {
            //元素超出边界
            if(i >= mid + 1) {
                nums[k] = temp[j];
                j++;
                continue;
            } else if(j >= right + 1) {
                nums[k] = temp[i];
                i++;
                continue;
            }

            if(temp[i] <= temp[j]) {  // 注意这里 = 是为了保持元素的稳定性
                nums[k] = temp[i];
                i++;
            } else if(temp[i] > temp[j]) {
                nums[k] = temp[j];
                j++;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        arr = mergeSortArr(arr);
        for (int n: arr) {
            System.out.println(n);
        }
    }

}
