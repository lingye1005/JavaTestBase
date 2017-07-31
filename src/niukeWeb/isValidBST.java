package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/22.
 * 判定一棵二叉树是否为二叉查找树
 * 思想:中序遍历,记录上一次节点值,一旦出现本次访问节点值<上次访问节点值,则返回false
 */
public class isValidBST {
    boolean flag=true;
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        Inorder(root);
        return flag;
    }
    void Inorder(TreeNode root){
        if(root==null)
            return;
        if(flag==false)
            return;
        Inorder(root.left);
        if(pre!=null){
            if(pre.val>=root.val)
                flag=false;
        }
        pre=root;
        Inorder(root.right);
    }

    public static void main(String[] args) {
        isValidBST te=new isValidBST();
        TreeNode root=new TreeNode(2);
        TreeNode ch1=new TreeNode(1);
        TreeNode ch2=new TreeNode(3);

        root.left=ch1;
        root.right=ch2;
        ch1.left=null;
        ch1.right=null;
        ch2.right=null;

        te.isValidBST(root);

    }
}
