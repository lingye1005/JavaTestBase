package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/31.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 自己写的代码,发现慢慢会写递归了,有进步啊
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        return helper(root);
    }
    private boolean helper(TreeNode root){
        if(root!=null){
                if(Math.abs(getDepth(root.left)-getDepth(root.right))>1)
                    return false;
                else{
                    return  helper(root.left) && helper(root.right);
                }
        }else{
            return true;
        }
    }
    private int getDepth(TreeNode root){
        if(root==null)
            return 0;
        else
            return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }

    public static void main(String[] args) {
        IsBalanced t=new IsBalanced();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        //TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;//t1.right=t3;
        t2.left=t4;
        System.out.println(t.IsBalanced_Solution(t1));
    }
}
