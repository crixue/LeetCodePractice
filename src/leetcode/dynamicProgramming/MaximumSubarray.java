package leetcode.dynamicProgramming;

public class MaximumSubarray {

    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        int maxCount = 0;

        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    private int maxSubSurrounding(int[] nums, int mid, int left, int right) {
        int leftMax = nums[mid], leftTotal = leftMax;
        for (int i=mid-1; i >= left; i--) {
            leftTotal += nums[i];
            leftMax = Math.max(leftMax, leftTotal);
        }

        int rightMax = nums[mid], rightTotal = rightMax;
        for (int i=mid+1; i <= right; i++) {
            rightTotal += nums[i];
            rightMax = Math.max(rightMax, rightTotal);
        }

        return Math.max(nums[mid], max3(leftMax, rightMax, leftMax + rightMax - nums[mid]));
    }


    private int maxSubArray(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return max3(maxSubArray(nums, left, mid),
                maxSubSurrounding(nums, mid, left, right),
                maxSubArray(nums, mid+1, right)
        );

    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;

        return maxSubArray(nums, 0, len-1);
    }

}
