package leetcode.arr;

public class MaximumSubArray {

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    private int maxCrossingSum(int[] nums, int left, int right, int mid) {
        if(left >= right) {
            return nums[left];
        }
        int leftSum = nums[mid], leftSumMax = leftSum;
        for (int i = mid-1; i >= left; i--) {
            leftSum += nums[i];
            leftSumMax = Math.max(leftSum, leftSumMax);
        }

        int rightSum = nums[mid], rightSumMax = rightSum;
        for (int i = mid+1; i <= right ; i++) {
            rightSum += nums[i];
            rightSumMax = Math.max(rightSum, rightSumMax);
        }

        return leftSumMax + rightSumMax - nums[mid];
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if(left >= right) {
            return nums[left];
        }

        int mid = (left + right) / 2;
        int leftSubMaxSum = maxSubArray(nums, left, mid);
        int rightSubMaxSum = maxSubArray(nums, mid+1, right);

        int crossingSubMaxSum = maxCrossingSum(nums, left, right, mid);
        return max3(leftSubMaxSum, rightSubMaxSum, crossingSubMaxSum);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        dp[0] = nums[0];
        int maximum = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            maximum = Math.max(maximum, dp[i]);
        }

        return maxSubArray(nums, 0, len-1);
//        return maximum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int i = maximumSubArray.maxSubArray(nums);
        System.out.println(i);
    }

}
