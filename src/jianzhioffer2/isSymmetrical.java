package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 11:30
 * @ProjectName: JavaBaseTest
 */
public class isSymmetrical {

    ///test
    public static void main(String[] args) {
        isSymmetrical t=new isSymmetrical();
        TreeNode root=new TreeNode(8);
        TreeNode l1=new TreeNode(6);
        TreeNode l2=new TreeNode(9);
        TreeNode l3=new TreeNode(5);
        TreeNode l4=new TreeNode(7);
        TreeNode l5=new TreeNode(7);
        TreeNode l6=new TreeNode(5);
        root.left=l1;root.right=l2;
        l1.left=l3;l1.right=l4;
        l2.left=l5;l2.right=l6;

        System.out.println(t.isSymmetrical(root));
        System.out.println(t.sb);
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null ||(pRoot.left==null && pRoot.right==null))
            return true;
        inOrder(pRoot);
        if(isBalaned(sb))
            return true;
        else
            return false;
    }
    StringBuilder sb=new StringBuilder();
    //中序 遍历
    private void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        //deal
        sb.append(root.val);
        inOrder(root.right);
    }
    //判定字符串是否对称
    private boolean isBalaned(StringBuilder sb){
        StringBuilder tmp=new StringBuilder(sb);
        sb.reverse();
        return sb.toString().equals(tmp.toString());
    }
}
