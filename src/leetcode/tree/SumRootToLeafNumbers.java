package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {

    private List<StringBuilder> mergeNumbers(TreeNode root) {
        List<StringBuilder> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<StringBuilder> leftNums = mergeNumbers(root.left);
        for (StringBuilder stringBuilder : leftNums) {
            stringBuilder.append(root.val);
        }
        List<StringBuilder> rightNums = mergeNumbers(root.right);
        for (StringBuilder stringBuilder : rightNums) {
            stringBuilder.append(root.val);
        }
        list.addAll(leftNums);
        list.addAll(rightNums);
        if (list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder().append(root.val);
            list.add(stringBuilder);
        }
        return list;
    }

    private int plusAllNums(List<StringBuilder> stringBuilderList) {
        int n = 0;
        for (StringBuilder item : stringBuilderList) {
            Integer value = Integer.valueOf(item.reverse().toString());
            n += value;
        }

        return n;
    }

    public int sumNumbers(TreeNode root) {
        return plusAllNums(mergeNumbers(root));
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumRootToLeafNumbers.sumNumbers(root));
    }

}
