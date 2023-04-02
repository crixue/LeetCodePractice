package leetcode.binarySearch;

public class LeftBoundBinarySearch {

    private int leftBoundBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            int midVal = nums[mid];
            if(midVal >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(left >= 0) {
            return left;
        }

        return -1;
    }

    public static void main(String[] args) {
        LeftBoundBinarySearch leftBoundBinarySearch = new LeftBoundBinarySearch();
        int[] nums = {1,2,3,3,3,4,5};
        int target = 3;
        System.out.println(leftBoundBinarySearch.leftBoundBinarySearch(nums, target));
    }

}
