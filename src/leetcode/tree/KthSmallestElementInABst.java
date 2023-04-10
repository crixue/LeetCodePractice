package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class KthSmallestElementInABst {

    private int kthVal = -1;
    private int findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return k;
        }
        k = findKthSmallest(root.left, k);
        if(k == 1) {
            kthVal = root.val;
        }
        k -= 1;
        k = findKthSmallest(root.right, k);
        return k;
    }

    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return kthVal;
    }

    public static void main(String[] args) {
        KthSmallestElementInABst kthSmallestElementInABst = new KthSmallestElementInABst();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(kthSmallestElementInABst.kthSmallest(root, 3));
    }

}
