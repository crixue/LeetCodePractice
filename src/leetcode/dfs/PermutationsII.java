package leetcode.dfs;

import java.util.*;

public class PermutationsII {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        //nums to LinkedList
        LinkedList<Integer> numsList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        LinkedList<Integer> item = new LinkedList<>();
        backtrace(numsList, item);
        return res;
    }

    private void backtrace(LinkedList<Integer> numsList, LinkedList<Integer> item) {
        if (numsList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            list.addAll(item);
            res.add(list);
            return;
        }
        int size = numsList.size();

        for (int j = 0; j < size; j++) {
            Integer numJ = numsList.remove(j);
            item.addLast(numJ);
            backtrace(numsList, item);
            item.removeLast();
            numsList.add(j, numJ);
            while (j+1 < size && numsList.get(j+1) == numJ) {
                j++;
            }
        }

    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = permutationsII.permuteUnique(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
