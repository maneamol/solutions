//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenTree {

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;

        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode leftNode = flattenTree(node.left);
        TreeNode rightNode = flattenTree(node.right);
        System.out.println("----");
        System.out.println("Node " + (node == null? "null":node.val));
        System.out.println("Left Node " + (leftNode == null ? "null": leftNode.val));
        System.out.println("Right Node " + (rightNode == null ? "null": rightNode.val));
        System.out.println("node.Left " + (node.left == null ? "null": node.left.val));
        System.out.println("node.right " + (node.right == null ? "null": node.right.val));

        System.out.println();
        System.out.println();
        if (leftNode != null) {
            leftNode.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightNode == null ? leftNode:rightNode;
    }

    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    public static void main(String[] args) {
        FlattenTree obj = new FlattenTree();

        TreeNode root = new TreeNode(1);
//
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
//
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        obj.flatten(root);

    }
}
