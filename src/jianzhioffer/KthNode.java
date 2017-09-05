package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/2.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthNode {
    int count=0;
    TreeNode result=null;
    TreeNode KthNode(TreeNode pRoot, int k){
        helper(pRoot,k);
        return result;
    }

    TreeNode helper(TreeNode tnode,int k){
        if(tnode!=null) {
            helper(tnode.left,k);
            count++;
            if (k == count)
                result=tnode;
            helper(tnode.right,k);
        }
        return null;
    }

    public static void main(String[] args) {
        KthNode t=new KthNode();
        TreeNode root=new TreeNode(5);
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(7);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(8);
        root.left=t1;root.right=t2;
        t1.left=t3;
        t2.left=t4;t2.right=t5;
        TreeNode out=t.KthNode(root,1);
        if(out!=null)
            System.out.println(out.val);
        else
            System.out.println("null");
    }
}
