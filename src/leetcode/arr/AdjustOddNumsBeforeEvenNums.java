package leetcode.arr;

public class AdjustOddNumsBeforeEvenNums {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int[] exchange(int[] nums) {
        int len = nums.length;

        int oddZero = -1, evenZero = len;
        for (int i = 0; i < evenZero;) {
            if((nums[i] & 1) == 1) {  //odd
                oddZero++;
                swap(nums, i ,oddZero);
                i++;
            } else {
                evenZero--;
                swap(nums, i, evenZero);
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        AdjustOddNumsBeforeEvenNums adjustOddNumsBeforeEvenNums = new AdjustOddNumsBeforeEvenNums();
        int[] nums = {1,2,3,4};
        int[] exchange = adjustOddNumsBeforeEvenNums.exchange(nums);
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }
    }

}
