package leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> res;

    private void dfs(int[] candidates, int target, int candIndex, LinkedList<Integer> item) {
        if (res.size() >= 150 || target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = candIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            item.addLast(candidate);
            dfs(candidates, target - candidate, i, item);
            item.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(candidates, target, 0, new LinkedList<>());
        return res;
    }

}
