package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/9/2.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 算法思想:两种中序遍历结果一样:一种是先访问左子树,另一种是先访问右子树.
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null)
            return true;
        return helper(pRoot.left,pRoot.right);
    }
    boolean helper(TreeNode left,TreeNode right){
        if(left==null && left==right)
            return true;
        else if(left==null || right==null)
            return false;
        else if(left.val!=right.val)
            return false;
        else {
            return helper(left.left,right.right) && helper(left.right,right.left);
        }
    }


    public static void main(String[] args) {
        IsSymmetrical t=new IsSymmetrical();
        TreeNode root=new TreeNode(1);
        TreeNode l1=new TreeNode(2);
        TreeNode l2=new TreeNode(2);
        TreeNode l3=new TreeNode(3);
        l2.left=l3;
        root.left=l1;root.right=l2;
        System.out.println(t.isSymmetrical(root));
    }
}
