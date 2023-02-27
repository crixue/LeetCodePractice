package leetcode.arr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    private List<List<Integer>> res = new ArrayList<>();

    public void backtrace(int[] nums, int startIndex, LinkedList<Integer> item) {
        int len = nums.length;
        res.add(new ArrayList<>(item));
        if (startIndex >= len) {
            return;
        }

        for (int i = startIndex; i < len; i++) {
            item.addLast(nums[i]);
            backtrace(nums, i + 1, item);
            item.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0, new LinkedList<>());
        return res;
    }

}
