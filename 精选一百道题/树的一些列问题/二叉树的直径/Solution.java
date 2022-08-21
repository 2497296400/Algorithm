package 精选一百道题.树的一些列问题.二叉树的直径;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(1);
        TreeNode t5=new TreeNode(1);
        TreeNode t6=new TreeNode(1);



    }
    private  int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return  0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftSize=0;
        int rightSize=0;
        if(root.left!=null){
            leftSize=dfs(root.left)+1;
        }
        if(root.right!=null){
            rightSize=dfs(root.right)+1;
        }
        max=Math.max(max,leftSize+rightSize);
        return  Math.max(leftSize,rightSize);
    }
}
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }