package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/26.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    String pre1=new String();
    String pre2=new String();
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        preOrder(root1,1);
        preOrder(root2,2);
        if( pre1.contains(pre2) && !pre2.equals(""))
            return true;
        else
            return false;
    }
    //先序遍历
    void preOrder(TreeNode root,int flag){
        if(root!=null){
            if(flag==1) {
                pre1 += String.valueOf(root.val);
                preOrder(root.left,1);
                preOrder(root.right,1);
            }
            else {
                pre2 += String.valueOf(root.val);
                preOrder(root.left,2);
                preOrder(root.right,2);
            }
        }
    }

    //test code
    public static void main(String[] args) {
        TreeNode l1=new TreeNode(8);
        TreeNode l2=new TreeNode(8);
        TreeNode l3=new TreeNode(7);
        TreeNode l4=new TreeNode(9);
        TreeNode l5=new TreeNode(2);
        TreeNode l6=new TreeNode(4);
        TreeNode l7=new TreeNode(7);

        TreeNode l8=new TreeNode(8);
        TreeNode l9=new TreeNode(9);
        TreeNode l10=new TreeNode(2);
        l1.left=l2;l1.right=l3;
        l2.left=l4;l2.right=l5;
        l5.left=l6;l5.right=l7;

        l8.left=l9;;l8.right=l10;

        HasSubtree test=new HasSubtree();
        System.out.println(test.HasSubtree(l1,l8));
        System.out.println(test.pre1);
        System.out.println(test.pre2);

    }
}
