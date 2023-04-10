package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        for (int lv = 0; !queue.isEmpty(); lv++) {
            int qz = queue.size();
            boolean nxtLvEnd = false;
            for (int i = 0; i < qz; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    if (nxtLvEnd) {
                        return false;
                    }
                    queue.addLast(node.left);
                } else {
                    nxtLvEnd = true;
                }

                if (node.right != null) {
                    if (nxtLvEnd) {
                        return false;
                    }
                    queue.addLast(node.right);
                } else {
                    nxtLvEnd = true;
                }
            }

            if(Math.pow(2, lv) > qz && !queue.isEmpty()) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckCompletenessOfABinaryTree checkCompletenessOfABinaryTree = new CheckCompletenessOfABinaryTree();
        //[1,2,3,4,5,6,7,8,9,10,11,12,13,null,null,15]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.left.left.left.left = new TreeNode(14);
        root.left.left.left.right = new TreeNode(15);
        boolean completeTree = checkCompletenessOfABinaryTree.isCompleteTree(root);
        System.out.println(completeTree);
    }

}
