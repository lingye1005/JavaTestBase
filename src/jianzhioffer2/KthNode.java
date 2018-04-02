package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/27 17:52
 * @ProjectName: JavaBaseTest
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k<0 || pRoot==null)
            return null;
        inOrder(pRoot,k);
        return res;
    }

    //中序遍历第kge
    int count=0;
    TreeNode res=null;
    void inOrder(TreeNode tnode,int k){

        if(tnode==null)
            return;
        inOrder(tnode.left,k);
        count++;
        if(count==k)
            res=tnode;
        inOrder(tnode.right,k);
    }

    //test
    public static void main(String[] args) {
        KthNode t=new KthNode();
        TreeNode root=new TreeNode(5);
        TreeNode l1=new TreeNode(3);
        TreeNode l2=new TreeNode(7);
        TreeNode l3=new TreeNode(2);
        TreeNode l4=new TreeNode(4);
        TreeNode l5=new TreeNode(6);
        TreeNode l6=new TreeNode(8);
        root.left=l1;root.right=l2;
        l1.left=l3;l1.right=l4;
        l2.left=l5;l2.right=l6;

        TreeNode res=t.KthNode(root,3);
        if(res!=null)
            System.out.println(res.val);
        else
            System.out.println("null");
    }
}
