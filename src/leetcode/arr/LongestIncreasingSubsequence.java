package leetcode.arr;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int maxLen = 1;
        arr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int vari = nums[i];
            if (vari > arr[maxLen-1]) {
                arr[maxLen] = vari;
                maxLen++;
                continue;
            }
            if(vari < arr[0]) {
                arr[0] = vari;
                continue;
            }
            int left = 1, right = maxLen, mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                int midVal = arr[mid];
                if(midVal == vari) {
                    break;
                } else if (arr[mid-1] >= vari) {
                    right = mid - 1;
                } else if(arr[mid] < vari) {
                    left = mid + 1;
                } else if(arr[mid-1] < vari && arr[mid] > vari) {
                    arr[mid] = vari;
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int i = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(i);
    }

}
