package leetcode.arr;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(i-1 >= 0 && nums[i-1] == nums[i]) continue;
            int left = i+1, right = len-1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if(target == 0) {
                    List<Integer> item = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    res.add(item);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if(target < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
