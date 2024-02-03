//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfTree {
    private int dia = Integer.MIN_VALUE;
    public int getDia(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = getDia(root.left);
        int rh = getDia(root.right);

        dia = Math.max(dia, (lh + rh));
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        DiameterOfTree obj = new DiameterOfTree();

        TreeNode root = new TreeNode(1);
//
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
//
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(obj.getDia(root));
    }
}
