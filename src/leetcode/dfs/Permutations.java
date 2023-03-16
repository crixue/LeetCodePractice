package leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums, new LinkedList<>());
        return res;
    }

    private void backtrace(int[] nums, LinkedList<Integer> item) {
        int len = nums.length;
        if (item.size() == len) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (item.contains(nums[i])) {
                continue;
            }
            item.addLast(nums[i]);
            backtrace(nums, item);
            item.removeLast();
        }
    }

}
