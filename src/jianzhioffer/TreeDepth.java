package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/31.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return  0;
        else
            return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeDepth t=new TreeDepth();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;t1.right=t3;
        t2.left=t4;
        System.out.println(t.TreeDepth(t1));
    }
}
