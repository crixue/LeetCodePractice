package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class MaximumPathSum {

    private int max = Integer.MIN_VALUE;

    private int max4(int a, int b, int c, int d) {
        return Math.max(Math.max(Math.max(a, b), c), d);
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int traverse(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftVal = traverse(root.left);
        int rightVal = traverse(root.right);

        int curMax = max4(root.val + leftVal + rightVal, root.val + leftVal, root.val + rightVal, root.val);
        max = Math.max(curMax, max);
        return max3(root.val + leftVal, root.val + rightVal, root.val);
    }

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

}
