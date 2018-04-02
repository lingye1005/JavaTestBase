package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 21:30
 * @ProjectName: JavaBaseTest
 */
public class IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1)
            return false;
        else
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    private int getDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
