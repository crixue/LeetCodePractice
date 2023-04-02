package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    private final String NULL_EOF = "null";
    private void serialize2StringBuilder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_EOF).append(",");
            return;
        }

        sb.append(root.val).append(",");
        serialize2StringBuilder(root.left, sb);
        serialize2StringBuilder(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serialize2StringBuilder(root, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private TreeNode deserialize2TreeNode(TreeNode treeNode, LinkedList<String> nodeVals) {
        if(nodeVals.isEmpty()) {
            return null;
        }
        String first = nodeVals.pollFirst();
        if (first.equals(NULL_EOF)) {
            return null;
        }

        treeNode = new TreeNode(Integer.valueOf(first));
        treeNode.left = deserialize2TreeNode(null, nodeVals);
        treeNode.right = deserialize2TreeNode(null, nodeVals);
        return treeNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeVals = data.split(",");
        LinkedList<String> linkedList = new LinkedList<String>(Arrays.asList(nodeVals));
        if (nodeVals.length == 0 || nodeVals[0].equals(NULL_EOF)) {
            return null;
        }

        TreeNode root = null;
        root = deserialize2TreeNode(root, linkedList);
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = serializeAndDeserializeBinaryTree.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = serializeAndDeserializeBinaryTree.deserialize(serialize);
        System.out.println(deserialize);
    }

}
