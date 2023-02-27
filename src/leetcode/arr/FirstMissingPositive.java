package leetcode.arr;

public class FirstMissingPositive {
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 原地哈希：让数字i回到 i-1的下标下
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if(nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
//        int[] nums = new int[]{1, 1};
        int[] nums = new int[]{3, 1, 4, -1};
        int i = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(i);
    }

}
