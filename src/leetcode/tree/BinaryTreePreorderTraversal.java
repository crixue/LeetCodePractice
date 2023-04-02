package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {

    private List<Integer> res = new ArrayList<>();

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return iteratePreOderTreeNode(root);
    }


    private List<Integer> iteratePreOderTreeNode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();

        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            root = root.right;
        }
        return res;
    }
}
