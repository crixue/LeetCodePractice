package leetcode.tree.git;

public class TreeTest1 {

    /**
     @Params:
     preorder: 前序数组
     preLeft：前序最左侧下标
     preRight：前序最右侧下标
     inorder： 中序数组
     inLeft： 中序最左侧下标
     inRight： 中序最右侧下标
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,int[] inorder, int inLeft, int inRight) {

        //base case
        if(preLeft<preRight || inLeft<inRight) {
            return null;
        }

        //pivot 中序的root节点
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = inLeft;
        while(inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }

        root.left = buildTree(preorder, preLeft+1, pivotIndex+preLeft-inLeft, inorder, inLeft, pivotIndex-1);
        root.right = buildTree(preorder, pivotIndex+preLeft-inLeft+1, preRight, inorder, pivotIndex+1, inRight);
        return root;
    }

}
