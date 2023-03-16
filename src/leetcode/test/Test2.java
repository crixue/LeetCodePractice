package leetcode.test;

public class Test2 {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int[] mergeSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len-1, temp);

        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        if(nums[mid] <= nums[mid+1]) {
            return;
        }

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];

        }
        for (int i = left, j = mid + 1, k = left; k <= right ; k++) {
            if(i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
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

}
