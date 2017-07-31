package niukeWeb;

import java.util.*;

/**
 * Created by caoxiaohong on 17/5/13.
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals the given sum.
 * 给定一棵二叉树和一个整数,判定二叉树中是否存在这样一条路径,满足:从根节点到叶子节点路径上的所有节点之和等于给定的整数.
 *
 */

public class hasPathSum {
    public boolean hasPathSumTest(TreeNode root, int sum) {
        if(root==null) {
                return false;
        }
        if(root.left==null && root.right==null) {
            if(root.val==sum)
                return true;
            else
                return false;
        }

        HashMap<Integer,Integer> paths=new HashMap<Integer, Integer>();//存放各个节点:从root到自己的路径
        //int sums=0;//记录路径和
        int rears=0;//该节点是第几个被访问到的
        int fronts=0;
        //采用层序遍历,入队时,记录前驱path

        Queue<TreeNode> queues=new LinkedList<TreeNode>();
        queues.add(root);
        paths.put(rears++,root.val);//存放入队节点的路径;

        while(!queues.isEmpty()){ //队列不为空
            TreeNode temps=queues.poll(); //出队

            if(temps.right==null && temps.left==null){  //节点为叶子节点,则被记录,备用求和
                //leafNode.add(visitNo);
                //sums+=Integer.parseInt(paths.get(fronts)) ;
                //front++;
                int leafSum=paths.get(fronts);
                if(leafSum==sum){
                    return true;
                }
            }
            if(temps.left!=null){
                queues.add(temps.left);
                paths.put(rears++,paths.get(fronts)+temps.left.val);
            }
            if(temps.right!=null){
                queues.add(temps.right);
                paths.put(rears++,paths.get(fronts)+temps.right.val);
            }
            fronts++;//出队,对头+1
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode ch1=new TreeNode(4);
        TreeNode ch2=new TreeNode(8);
        TreeNode ch3=new TreeNode(11);
        TreeNode ch4=new TreeNode(13);
        TreeNode ch5=new TreeNode(4);
        TreeNode ch6=new TreeNode(7);
        TreeNode ch7=new TreeNode(2);
        TreeNode ch8=new TreeNode(1);

        root.left=ch1;
        root.right=ch2;
        ch1.left=ch3;
        ch1.right=null;
        ch2.left=ch4;
        ch2.right=ch5;
        ch3.left=ch6;
        ch3.right=ch7;
        ch4.left=null;
        ch4.right=null;
        ch5.left=null;
        ch5.right=ch8;
        ch6.left=null;
        ch6.right=null;
        ch7.left=null;
        ch7.right=null;
        ch8.left=null;
        ch8.right=null;
        hasPathSum test=new hasPathSum();

        System.out.println(test.hasPathSumTest(root,22));
    }
}
