package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class BalancedBinaryTree {

    private int balancedDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = balancedDepth(root.left);
        int rightDepth = balancedDepth(root.right);

        if(leftDepth == Integer.MIN_VALUE || rightDepth == Integer.MIN_VALUE || Math.abs(leftDepth-rightDepth) > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int depth = balancedDepth(root);
        if(depth == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        //example:[1,2,2,3,null,null,3,4,null,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        System.out.println(balancedBinaryTree.isBalanced(root));
    }

}
