package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostorderTraversal {

    private List<Integer> res = new ArrayList<>();

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        return iteratePreOderTreeNode(root);
    }


    private List<Integer> iteratePreOderTreeNode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();

        TreeNode prev = null;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stk.push(root);
                root = root.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode l2a1 = new TreeNode(5);
        TreeNode l2a2 = new TreeNode(4);
        TreeNode l2a3 = new TreeNode(6);

        TreeNode l1a1 = new TreeNode(2, l2a2, l2a1);
        TreeNode l1a2 = new TreeNode(3, null, l2a3);

        TreeNode root = new TreeNode(1, l1a1, l1a2);

        BinaryTreePostorderTraversal binaryTreeInorderTraversal = new BinaryTreePostorderTraversal();
        List<Integer> integers = binaryTreeInorderTraversal.postorderTraversal(root);
        for (Integer integer : integers) {
            System.out.println(integer.toString());
        }
    }
}
