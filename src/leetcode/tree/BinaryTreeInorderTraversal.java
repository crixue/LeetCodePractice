package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
//        traverse(root);
//        return res;
        return iterateInOrderTreeNode(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }

    private List<Integer> iterateInOrderTreeNode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();

        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode l2a1 = new TreeNode(5);
        TreeNode l2a2 = new TreeNode(4);
        TreeNode l2a3 = new TreeNode(6);

        TreeNode l1a1 = new TreeNode(2, l2a2, l2a1);
        TreeNode l1a2 = new TreeNode(3, null, l2a3);

        TreeNode root = new TreeNode(1, l1a1, l1a2);

        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> integers = binaryTreeInorderTraversal.iterateInOrderTreeNode(root);
        for (Integer integer : integers) {
            System.out.println(integer.toString());
        }
    }

}
