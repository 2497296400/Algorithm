package 精选一百道题.树的一些列问题.二叉树节点的最大路径和;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node.right.left = node3;
        node.right.right = node4;

        System.out.println(maxPathSum(node));

    }

    public static int maxPath = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPath;
    }

    private static int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxPath = Math.max(maxPath(root.left), 0);
        int rightMaxPath = Math.max(maxPath(root.right), 0);
        maxPath = Math.max(maxPath, leftMaxPath + rightMaxPath + root.val);
        return Math.max(leftMaxPath, rightMaxPath) + root.val
                ;
    }

}
