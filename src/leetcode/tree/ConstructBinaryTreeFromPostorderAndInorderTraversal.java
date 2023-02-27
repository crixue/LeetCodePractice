package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int inRootIndex = inStart, lLen = inRootIndex - inStart, rLen = inEnd - inRootIndex;
        for (; inRootIndex <= inEnd; inRootIndex++) {
            if (rootVal == inorder[inRootIndex]) {
                lLen = inRootIndex - inStart;
                rLen = inEnd - inRootIndex;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, postorder, inStart, inRootIndex-1, postStart, postStart+lLen-1);
        root.right = buildTree(inorder, postorder, inRootIndex+1, inEnd, postStart+lLen, postStart+lLen+rLen-1);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return buildTree(inorder, postorder, 0, len-1, 0, len-1);
    }
}
