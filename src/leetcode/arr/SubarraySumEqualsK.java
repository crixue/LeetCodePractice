package leetcode.arr;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] preSum = new int[nums.length + 1];
        memo.put(0, 1);

        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = nums[i-1] + preSum[i-1];
            int target = preSum[i] - k;
            count += memo.getOrDefault(target, 0);
            memo.put(preSum[i], memo.getOrDefault(preSum[i], 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = {0, 0, 0};
        int k = 0;
        System.out.println(subarraySumEqualsK.subarraySum(nums, k));
    }

}
