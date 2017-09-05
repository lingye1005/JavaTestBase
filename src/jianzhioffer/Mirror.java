package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/26.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        helper(root);
    }
    void helper(TreeNode root){
        if(root!=null){
            TreeNode tmp=root.left;
            root.left=root.right;
            root.right=tmp;
            helper(root.left);
            helper(root.right);
        }
    }

    //test <code></code>
    public static void main(String[] args) {
        Mirror t=new Mirror();
        TreeNode l1=new TreeNode(8);
        TreeNode l2=new TreeNode(6);
        TreeNode l3=new TreeNode(10);
        TreeNode l4=new TreeNode(5);
        TreeNode l5=new TreeNode(7);
        TreeNode l6=new TreeNode(9);
        TreeNode l7=new TreeNode(11);
        l1.left=l2;l1.right=l3;
        l2.left=l4;l2.right=l5;
        l3.left=l6;l3.right=l7;
        t.Mirror(l1);
    }
}
