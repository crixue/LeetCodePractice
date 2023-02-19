package leetcode.arr;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            int lv = nums[left];
            int rv = nums[right];
            int midVal = nums[mid];
            if(midVal == target) {
                return mid;
            } else if(midVal < target) {
                if(midVal > lv) {  //左有序
                    left = mid + 1;
                    continue;
                }
                //左无序
                if(target > rv) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(midVal < rv) {  //右有序
                    right = mid - 1;
                    continue;
                }
                //右无序
                if(target < lv) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

}
