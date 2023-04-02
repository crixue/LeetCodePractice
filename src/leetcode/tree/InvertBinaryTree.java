package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invertTreeBacktrace(root);
        return root;
    }

    private void invertTreeBacktrace(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = right;
        invertTreeBacktrace(root.left);
        invertTreeBacktrace(root.right);
    }

}
