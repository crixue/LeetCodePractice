package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];

        int rootIndexIn = inStart, lLen = rootIndexIn - inStart, rLen = inEnd - rootIndexIn;
        for (; rootIndexIn <= inEnd; rootIndexIn++) {
            if (inorder[rootIndexIn] == rootVal) {
                lLen = rootIndexIn - inStart;
                rLen = inEnd - rootIndexIn;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + lLen, inStart, rootIndexIn - 1);
        root.right = buildTree(preorder, inorder, preStart + lLen + 1, preStart + lLen + rLen, rootIndexIn + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        return buildTree(preorder, inorder, 0, len-1, 0, len-1);
    }

    public static void main(String[] args) {

//        TreeNode l3a1 = new TreeNode(10);
//        TreeNode l3a2 = new TreeNode(6);
//        TreeNode l3r1 = new TreeNode(8);
//
//        TreeNode l2a1 = new TreeNode(7, l3r1, null);
//        TreeNode l2a2 = new TreeNode(15, l3a1, l3a2);
//
//        TreeNode l1a1 = new TreeNode(9);
//        TreeNode l1a2 = new TreeNode(20, l2a1, l2a2);
//
//        TreeNode root = new TreeNode(3, l1a1, l1a2);
        ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        TreeNode treeNode = obj.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
