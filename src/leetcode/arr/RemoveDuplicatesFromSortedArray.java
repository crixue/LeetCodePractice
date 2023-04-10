package leetcode.arr;

public class RemoveDuplicatesFromSortedArray {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        int slow = 0;
        for (int fast = slow + 1; fast < len; fast++) {
            if(nums[fast] > nums[slow]) {
                slow++;
                if(nums[slow-1] >= nums[slow]) {
                    swap(nums, slow, fast);
                }
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        System.out.println(i);
    }

}
