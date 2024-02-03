//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    private final static String MARKER = "NULL";
    private StringBuilder sb = new StringBuilder();
    private List<String> serialized = new ArrayList<>();
    private TreeNode root = null;

    private void serializeHelper(TreeNode node) {
        if (node == null) {
            serialized.add(MARKER);
            return;
        }
        serialized.add(String.valueOf(node.val));
        serializeHelper(node.left);
        serializeHelper(node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeHelper(root);
        String ser = String.join(",", serialized);
        // System.out.println(ser);
        return ser;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        List<String> list = Arrays.asList(data.split(","));

        List<String> list = Arrays.stream(data.split(",")).sequential().collect(Collectors.toList());

        deserializeHelper(list);
        return root;
    }

    private TreeNode deserializeHelper(List<String> list) {
        if (list.size() == 0) {
            return null;
        }

        String curVal= list.get(0);
        list.remove(0);

        if (curVal.equals("NULL")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(curVal));
        if (root == null) {
            root = node;
        }

        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
//
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Codec codec = new Codec();

        codec.deserialize(codec.serialize(root));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));