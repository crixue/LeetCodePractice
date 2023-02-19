package leetcode.arr;


public class SortColors {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int len = nums.length;

        int zeroZone = -1, twoZone = len, i = 0;
        while (i < twoZone) {
            if(nums[i] == 0) {
                zeroZone ++;
                swap(nums, zeroZone, i);
                i++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                twoZone--;
                swap(nums, twoZone, i);
            }
        }
    }

}
