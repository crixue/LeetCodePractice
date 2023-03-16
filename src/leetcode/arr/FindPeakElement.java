package leetcode.arr;

import java.util.Arrays;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return 0;
        }
        int[] numsDup = new int[len+2];
        numsDup[0] = Integer.MIN_VALUE;
        System.arraycopy(nums, 0, numsDup, 1, len);
        numsDup[len+1] = Integer.MIN_VALUE;

        int left = 1, right = len, mid = 0, targetIndex = -1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            int midVal = numsDup[mid];
            if(midVal > numsDup[mid-1] && midVal > numsDup[mid+1]) {
                targetIndex = mid - 1;
                break;
            } else if (midVal >= numsDup[mid-1] && midVal <= numsDup[mid+1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return targetIndex;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {-2147483648,-2147483647};
        int peakElement = findPeakElement.findPeakElement(nums);
        System.out.println(peakElement);
    }

}
