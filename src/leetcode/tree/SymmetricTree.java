package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null) || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.addLast(root.left);
//        queue.addLast(root.right);
//
//        while (!queue.isEmpty()) {
//            int qz = queue.size();
//            for (int i = 0; i < qz; i++) {
//                TreeNode left = queue.pollFirst();
//                TreeNode right = queue.pollFirst();
//
//                if (left == null && right == null) {
//                    continue;
//                }
//                if (left != null && right == null) {
//                    return false;
//                }
//                if (left == null && right != null) {
//                    return false;
//                }
//                if (left.val != right.val) {
//                    return false;
//                }
//                queue.addLast(left.left);
//                queue.addLast(right.right);
//                queue.addLast(left.right);
//                queue.addLast(right.left);
//            }
//        }
//        return true;
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode l2a1 = new TreeNode(3);
        TreeNode l2a2 = new TreeNode(3);

        TreeNode l1a1 = new TreeNode(2, l2a1, null);
        TreeNode l1a2 = new TreeNode(2, null, l2a2);

        TreeNode root = new TreeNode(1, l1a1, l1a2);
        boolean symmetric = symmetricTree.isSymmetric(root);
        System.out.println(symmetric);
    }

}
