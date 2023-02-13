package leetcode.sort;

public class Partice0 {


    private static void mergeSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSortArr(nums, 0, len-1, temp);
    }

    private static void mergeSortArr(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSortArr(nums, left, mid, temp);
        mergeSortArr(nums, mid+1, right, temp);

        if(nums[mid] <= nums[mid+1]) {
            return;
        }

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if(i >= mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j >= right + 1) {
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

    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
//        int[] arr = new int[]{-1, 3, 12, 3, 89, 9, -4, 9};

        mergeSort(arr);
        for (int n: arr) {
            System.out.println(n);
        }
    }

}
