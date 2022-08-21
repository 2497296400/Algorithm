package 周赛.三百零七.感染二叉树需要的总时间;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        //关联父节点 <当前结点，当前结点父节点>
        Map<TreeNode,TreeNode> map = new HashMap<>();
        //关联是否被感染 <当前结点，是否感染>
        Map<TreeNode,Boolean> flag = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root,null);  //根结点无父节点
        //指向感染结点
        TreeNode x = null;
        while(!queue.isEmpty()){
            int size = queue.size();

            //层序遍历，确定好每个结点的 父结点 及 是否被感染信息
            while(size!=0){
                TreeNode t = queue.poll();
                size--;
                //找到感染结点
                if(t.val == start){
                    x = t;
                    flag.put(t,true);
                }
                else
                    flag.put(t,false);

                if(t.left!=null){
                    queue.add(t.left);
                    map.put(t.left,t);
                }
                if(t.right!=null){
                    queue.add(t.right);
                    map.put(t.right,t);
                }
            }
        }

        //感染结点为首，入队
        queue.add(x);
        int minutes = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size!=0){
                TreeNode t = queue.poll();
                size--;
                if(t.left!=null && !flag.get(t.left)){
                    queue.add(t.left);
                    flag.put(t.left,true);
                }
                if(t.right!=null && !flag.get(t.right)){
                    queue.add(t.right);
                    flag.put(t.right,true);
                }

                //就层序遍历多扫一个父亲结点
                if(map.get(t)!=null && !flag.get(map.get(t))){
                    //父节点入队
                    queue.add(map.get(t));
                    flag.put(map.get(t),true);
                }

            }
            //每轮结束 minutes++
            minutes++;
        }
        return minutes-1;
    }
}

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