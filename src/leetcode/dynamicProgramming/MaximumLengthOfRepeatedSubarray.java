package leetcode.dynamicProgramming;

public class MaximumLengthOfRepeatedSubarray {

    /**
     * 718. Maximum Length of Repeated Subarray
     * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];

        int maxDuplicatedLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxDuplicatedLen = Math.max(maxDuplicatedLen, dp[i][j]);
                }
            }
        }

        return maxDuplicatedLen;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        int length = maximumLengthOfRepeatedSubarray.findLength(nums1, nums2);
        System.out.println(length);
    }

}
