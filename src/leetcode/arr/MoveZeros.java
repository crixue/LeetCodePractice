package leetcode.arr;

public class MoveZeros {

    public void moveZeroes1(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if(nums[i] == 0 || (nums[i-1] != 0 && nums[i] != 0)) continue;
            int left = 0, right = i-1, mid = 0;
            while (left <= right) {
                mid = (right - left) / 2 + left;
                if (nums[mid] == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            swap(nums, i, left);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;

        for (int i = 0, nonZero = -1; i < len; i++) {
            if(nums[i] != 0) {
                nonZero++;
                swap(nums, i, nonZero);
            }
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        moveZeros.moveZeroes(nums);
        System.out.println(nums);
    }

}
