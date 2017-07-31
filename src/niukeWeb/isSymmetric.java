package niukeWeb;


/**
 * Created by caoxiaohong on 17/6/19.
 * 判断一棵二叉树是否为对称树
 * 递归
 */
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
    //辅助算法
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        if(left.val!=right.val)
            return false;
        else
            return helper(left.left,right.right) && helper(left.right,right.left);
    }


    //test代码
    public static void main(String[] args) {
        isSymmetric t=new isSymmetric();
        TreeNode root=new TreeNode(1);
        TreeNode ch1=new TreeNode(2);
        TreeNode ch2=new TreeNode(2);
//        TreeNode ch3=new TreeNode(3);
//        TreeNode ch4=new TreeNode(2);

        root.left=ch1;
        root.right=ch2;
        ch1.left=null;
        ch1.right=null;
        ch2.left=null;
        ch2.right=null;
//        ch1.left=ch3;
//        ch1.right=null;
//        ch2.left=ch4;
//        ch2.right=null;
//        ch3.left=null;
//        ch3.right=null;
//        ch4.left=null;
//        ch4.right=null;

        boolean aa=t.isSymmetric(root);
        System.out.println(aa);
    }
}
