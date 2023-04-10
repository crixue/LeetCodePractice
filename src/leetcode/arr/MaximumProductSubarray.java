package leetcode.arr;

public class MaximumProductSubarray {

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    private int min3(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int preMax = nums[0], preMin = nums[0];

        int maxProduct = preMax;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            int curMax = max3(cur, cur*preMax, cur*preMin);
            int curMin = min3(cur, cur*preMax, cur*preMin);
            preMax = curMax;
            preMin = curMin;
            maxProduct = Math.max(maxProduct, curMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = new int[]{2,3,-2,4};
        int i = maximumProductSubarray.maxProduct(nums);
        System.out.println(i);
    }

}
