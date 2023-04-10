package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class KthLargestInBinaryTree {

    private Integer kthLargest = null;
    private int findKthLargestInTree(TreeNode root, int k) {
        if (root == null) {
            return k;
        }
        k = findKthLargestInTree(root.right, k);

        k -= 1;
        if(k == 0) {
            kthLargest = root.val;
        }

        k = findKthLargestInTree(root.left, k);
        return k;
    }

    public int kthLargest(TreeNode root, int k) {
        findKthLargestInTree(root, k);
        return kthLargest;
    }

    public static void main(String[] args) {
        KthLargestInBinaryTree kthLargestInBinaryTree = new KthLargestInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthLargestInBinaryTree.kthLargest(root, 1));
    }

}
