package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class DiameterOfBinaryTree {

    private int maxDiam = 0;
    private int maximumDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lMax = maximumDiameter(root.left);
        int rMax = maximumDiameter(root.right);

        maxDiam = Math.max(lMax + rMax, maxDiam);
        return Math.max(lMax, rMax) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int leftDiam = maximumDiameter(root.left);
        int rightDiam = maximumDiameter(root.right);
        maxDiam = Math.max(leftDiam + rightDiam, maxDiam);

        return maxDiam;
    }

}
