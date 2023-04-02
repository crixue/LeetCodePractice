package leetcode.binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[]{-1, -1};
        if (len == 0) {
            return res;
        }

        int left = 0, right = len-1, mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            int midVal = nums[mid];

            if(midVal >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= 0 && left < len && nums[left] == target) {
            res[0] = left;
        }

        right = len-1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            int midVal = nums[mid];

            if(midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right >= 0 && right < len && nums[right] == target) {
            res[1] = right;
        }
        return res;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {};
        int target = 0;
        int[] res = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

}
