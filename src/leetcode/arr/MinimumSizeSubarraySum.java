package leetcode.arr;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen1(int target, int[] nums) {
        int length = nums.length;

        int minSubLen = Integer.MAX_VALUE;
        int[] preSum = new int[length+1];
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            if(preSum[i] < target) continue;

            int left = 0, right = i, mid = 0;
            while (left <= right) {
                mid = (right - left) / 2 + left;
                int midVal = preSum[mid];
                if(preSum[i] - midVal >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            minSubLen = Math.min(minSubLen, i-right);
        }

        if(minSubLen == Integer.MAX_VALUE)
            return 0;

        return minSubLen;
    }


    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;

        int minSubLen = length+1, sum = 0;
        for (int left = 0, right = 0; right < length; right++) {
            sum += nums[right];
            if (sum < target) continue;
            while (left <= right) {
                sum -= nums[left];
                if (sum < target) {
                    minSubLen = Math.min(minSubLen, right-left+1);
                    left++;
                    break;
                }
                left++;
            }
        }
        if (minSubLen == length + 1) {
            return 0;
        }

        return minSubLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }
}
